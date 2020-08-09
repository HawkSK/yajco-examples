package yajco.robot.karel.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Condition;
import yajco.robot.karel.model.Statement;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Conditional extends Statement {
    private final Condition condition;

    private final Statement statement;

    private final Optional<Statement> elseStatement;

    @Before("IF")
    @After("ENDIF")
    public Conditional(
            Condition condition,
            @Before("THEN") Statement statement,
            @Before("ELSE") Optional<Statement> elseStatement) {
        this.condition = condition;
        this.statement = statement;
        this.elseStatement = elseStatement;
    }

    @Override
    public void execute(World world) {
        if (condition.eval(world)) {
            statement.execute(world);
        } else {
            elseStatement.ifPresent(elseStmt -> elseStmt.execute(world));
        }
    }
}
