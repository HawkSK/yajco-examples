package yajco.example.desk.model;

import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.Separator;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Program {
    private final Expression expression;

    private final Optional<Constant[]> constants;

    public Program(
            @Before("print")
                    Expression expression,
            @Before("where")
            @Range(minOccurs = 1)
            @Separator(",")
                    Optional<Constant[]> constants) {
        this.expression = expression;
        this.constants = constants;
    }

    public String code() {
        return getExpression().code();
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * @return the constants
     */
    public Optional<Constant[]> getConstants() {
        return constants;
    }
}
