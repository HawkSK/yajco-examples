@Parser(className = "yajco.example.json.parser.JsonParser",
		mainNode = "JsonValue",
		tokens = {
				@TokenDef(name = "STRING", regexp = "\"([^\"]*)\""),
				@TokenDef(name = "NUMBER", regexp = "([-]?(0|[1-9]\\d*)(\\.\\d+)?([eE][+-]?\\d+)?)"),
				@TokenDef(name = "BOOL", regexp = "(true)|(false)"),
		},
		skips = {
				@Skip(" "),
				@Skip("\\t"),
				@Skip("\\n"),
				@Skip("\\r")
		},
		options = {
				@Option(name = "yajco.generateTools", value = "all")
		}
)
package yajco.example.json.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
