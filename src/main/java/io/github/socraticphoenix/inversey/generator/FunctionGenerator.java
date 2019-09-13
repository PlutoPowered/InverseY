package io.github.socraticphoenix.inversey.generator;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;
import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;
import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;
import io.github.socraticphoenix.inversey.interfaces.FunctionX;
import io.github.socraticphoenix.jource.ast.annotation.JavaSourceAnnotation;
import io.github.socraticphoenix.jource.ast.block.JavaSourceIfBlock;
import io.github.socraticphoenix.jource.ast.definition.JavaSourceInterfaceDefinition;
import io.github.socraticphoenix.jource.ast.member.JavaSourceMethod;
import io.github.socraticphoenix.jource.ast.member.JavaSourceParameter;
import io.github.socraticphoenix.jource.ast.modifier.JavaSourceModifier;
import io.github.socraticphoenix.jource.ast.statement.JavaSourceReturnStatement;
import io.github.socraticphoenix.jource.ast.statement.JavaSourceThrowStatement;
import io.github.socraticphoenix.jource.ast.type.JavaSourceFilledGenerics;
import io.github.socraticphoenix.jource.ast.type.JavaSourceGenerics;
import io.github.socraticphoenix.jource.ast.type.JavaSourceNamespace;
import io.github.socraticphoenix.jource.ast.value.JavaSourceArrayGet;
import io.github.socraticphoenix.jource.ast.value.JavaSourceCast;
import io.github.socraticphoenix.jource.ast.value.JavaSourceConstructorCall;
import io.github.socraticphoenix.jource.ast.value.JavaSourceFieldReference;
import io.github.socraticphoenix.jource.ast.value.JavaSourceLiteral;
import io.github.socraticphoenix.jource.ast.value.JavaSourceMethodCall;
import io.github.socraticphoenix.jource.ast.value.JavaSourceThisReference;
import io.github.socraticphoenix.jource.ast.value.JavaSourceVariableReference;
import io.github.socraticphoenix.jource.ast.value.operator.JavaSourceBinaryOperator;
import io.github.socraticphoenix.jource.ast.value.operator.JavaSourceOperator;
import io.github.socraticphoenix.jource.io.JavaSourceFile;
import io.github.socraticphoenix.jource.io.JavaSourceFileSet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class FunctionGenerator {
    public static final int MAX_PARAMS = 255;
    public static final String PACKAGE = "io.github.socraticphoenix.inversey";

    public static JavaSourceFileSet generateConsumers() {
        JavaSourceFileSet set = new JavaSourceFileSet();
        for (int i = 0; i < MAX_PARAMS; i++) {
            JavaSourceGenerics generics = JavaSourceGenerics.empty();
            JavaSourceMethod call = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "accept");
            JavaSourceMethodCall arrayCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "accept");
            JavaSourceNamespace dangerous = JavaSourceNamespace.of(PACKAGE + ".DangerousConsumer" + i, JavaSourceGenerics.empty(), false);
            JavaSourceFilledGenerics dangerousFilled = JavaSourceFilledGenerics.empty();
            dangerousFilled.addElement(JavaSourceFilledGenerics.Element.of(JavaSourceNamespace.of(RuntimeException.class).fill()));

            for (int j = 0; j < i; j++) {
                String name = "P" + (j + 1);
                JavaSourceNamespace namespace = JavaSourceNamespace.of(name, JavaSourceGenerics.empty(), false);
                generics.set(name, Collections.emptyList());
                call.addParameter(JavaSourceParameter.of(namespace,
                        name.toLowerCase()));

                arrayCall.addParameter(JavaSourceCast.of(namespace, JavaSourceArrayGet.of(JavaSourceVariableReference.of("params"), JavaSourceLiteral.of(j))));
                dangerousFilled.addElement(JavaSourceFilledGenerics.Element.of(namespace.fill()));
            }

            JavaSourceMethod array = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "acceptArray");
            array.addParameter(JavaSourceParameter.of(JavaSourceNamespace.of(Object[].class), "params", true));

            array.addStatement(JavaSourceIfBlock.ifBlock(JavaSourceBinaryOperator.of(
                    JavaSourceFieldReference.of(JavaSourceVariableReference.of("params"), "length"),
                    JavaSourceOperator.NOT_EQUAL,
                    JavaSourceLiteral.of(i)
            )).addStatement(JavaSourceThrowStatement.of(JavaSourceConstructorCall.of(JavaSourceNamespace.of(IllegalArgumentException.class).fill())
                    .addParameter(JavaSourceLiteral.of("Expected exactly " + i + " parameters")))));
            array.addStatement(arrayCall);
            array.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceMethod parameterCount = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.of(int.class).fill(), "parameterCount");
            parameterCount.addStatement(JavaSourceReturnStatement.of(JavaSourceLiteral.of(i)));
            parameterCount.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceInterfaceDefinition definition = new JavaSourceInterfaceDefinition(PACKAGE + ".Consumer" + i, generics);
            definition.addInterface(JavaSourceNamespace.of(ConsumerX.class).fill()).addInterface(dangerous.fill(dangerousFilled)).addModifier(JavaSourceModifier.PUBLIC)
            .addMethod(call).addMethod(array).addMethod(parameterCount);
            set.add(new JavaSourceFile(definition));
        }

        return set;
    }

    public static JavaSourceFileSet generateDangerousConsumers() {
        JavaSourceFileSet set = new JavaSourceFileSet();
        for (int i = 0; i < MAX_PARAMS; i++) {
            JavaSourceGenerics generics = JavaSourceGenerics.empty();
            generics.set("T", Arrays.asList(JavaSourceNamespace.of(Throwable.class).fill()));
            JavaSourceMethod call = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "accept");
            JavaSourceMethodCall arrayCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "accept");
            JavaSourceNamespace.Filled throwable = JavaSourceNamespace.of("T", JavaSourceGenerics.empty(), false).fill();
            call.addThrowable(throwable);

            for (int j = 0; j < i; j++) {
                String name = "P" + (j + 1);
                JavaSourceNamespace namespace = JavaSourceNamespace.of(name, JavaSourceGenerics.empty(), false);
                generics.set(name, Collections.emptyList());
                call.addParameter(JavaSourceParameter.of(namespace,
                        name.toLowerCase()));

                arrayCall.addParameter(JavaSourceCast.of(namespace, JavaSourceArrayGet.of(JavaSourceVariableReference.of("params"), JavaSourceLiteral.of(j))));
            }

            JavaSourceMethod array = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "acceptArray");
            array.addParameter(JavaSourceParameter.of(JavaSourceNamespace.of(Object[].class), "params", true));

            array.addStatement(JavaSourceIfBlock.ifBlock(JavaSourceBinaryOperator.of(
                    JavaSourceFieldReference.of(JavaSourceVariableReference.of("params"), "length"),
                    JavaSourceOperator.NOT_EQUAL,
                    JavaSourceLiteral.of(i)
            )).addStatement(JavaSourceThrowStatement.of(JavaSourceConstructorCall.of(JavaSourceNamespace.of(IllegalArgumentException.class).fill())
                    .addParameter(JavaSourceLiteral.of("Expected exactly " + i + " parameters")))));
            array.addStatement(arrayCall);
            array.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));
            array.addThrowable(throwable);

            JavaSourceMethod parameterCount = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.of(int.class).fill(), "parameterCount");
            parameterCount.addStatement(JavaSourceReturnStatement.of(JavaSourceLiteral.of(i)));
            parameterCount.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceInterfaceDefinition definition = new JavaSourceInterfaceDefinition(PACKAGE + ".DangerousConsumer" + i, generics);
            definition.addInterface(JavaSourceNamespace.of(DangerousConsumerX.class).fill(JavaSourceFilledGenerics.empty().addElement(JavaSourceFilledGenerics.Element.of(throwable)))).addModifier(JavaSourceModifier.PUBLIC)
                    .addMethod(call).addMethod(array).addMethod(parameterCount);
            set.add(new JavaSourceFile(definition));
        }

        return set;
    }

    public static JavaSourceFileSet generateFunctions() {
        JavaSourceFileSet set = new JavaSourceFileSet();
        for (int i = 0; i < MAX_PARAMS; i++) {
            JavaSourceGenerics generics = JavaSourceGenerics.empty().set("R", Collections.emptyList());
            JavaSourceNamespace ret = JavaSourceNamespace.of("R", JavaSourceGenerics.empty(), false);
            JavaSourceFilledGenerics consumerGenerics = JavaSourceFilledGenerics.empty();
            JavaSourceMethod accept = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "accept");
            JavaSourceMethodCall acceptCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "apply");
            JavaSourceMethod call = JavaSourceMethod.of(JavaSourceGenerics.empty(), ret.fill(), "apply");
            JavaSourceMethodCall arrayCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "apply");
            JavaSourceMethodCall acceptArrayCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "accept");
            JavaSourceNamespace dangerous = JavaSourceNamespace.of(PACKAGE + ".DangerousFunction" + i, JavaSourceGenerics.empty(), false);
            JavaSourceFilledGenerics dangerousFilled = JavaSourceFilledGenerics.empty();
            dangerousFilled.addElement(JavaSourceFilledGenerics.Element.of(ret.fill()));
            dangerousFilled.addElement(JavaSourceFilledGenerics.Element.of(JavaSourceNamespace.of(RuntimeException.class).fill()));

            for (int j = 0; j < i; j++) {
                String name = "P" + (j + 1);
                JavaSourceNamespace namespace = JavaSourceNamespace.of(name, JavaSourceGenerics.empty(), false);
                generics.set(name, Collections.emptyList());
                consumerGenerics.addElement(JavaSourceFilledGenerics.Element.of(namespace.fill()));
                call.addParameter(JavaSourceParameter.of(namespace,
                        name.toLowerCase()));
                accept.addParameter(JavaSourceParameter.of(namespace,
                        name.toLowerCase()));
                acceptCall.addParameter(JavaSourceVariableReference.of(name.toLowerCase()));
                arrayCall.addParameter(JavaSourceCast.of(namespace, JavaSourceArrayGet.of(JavaSourceVariableReference.of("params"), JavaSourceLiteral.of(j))));
                acceptArrayCall.addParameter(JavaSourceCast.of(namespace, JavaSourceArrayGet.of(JavaSourceVariableReference.of("params"), JavaSourceLiteral.of(j))));
                dangerousFilled.addElement(JavaSourceFilledGenerics.Element.of(namespace.fill()));
            }

            JavaSourceMethod array = JavaSourceMethod.of(JavaSourceGenerics.empty(), ret.fill(), "applyArray");
            array.addParameter(JavaSourceParameter.of(JavaSourceNamespace.of(Object[].class), "params", true));

            array.addStatement(JavaSourceIfBlock.ifBlock(JavaSourceBinaryOperator.of(
                    JavaSourceFieldReference.of(JavaSourceVariableReference.of("params"), "length"),
                    JavaSourceOperator.NOT_EQUAL,
                    JavaSourceLiteral.of(i)
            )).addStatement(JavaSourceThrowStatement.of(JavaSourceConstructorCall.of(JavaSourceNamespace.of(IllegalArgumentException.class).fill())
                    .addParameter(JavaSourceLiteral.of("Expected exactly " + i + " parameters")))));
            array.addStatement(JavaSourceReturnStatement.of(arrayCall));
            array.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceMethod acceptArray = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "acceptArray");
            acceptArray.addParameter(JavaSourceParameter.of(JavaSourceNamespace.of(Object[].class), "params", true));

            acceptArray.addStatement(JavaSourceIfBlock.ifBlock(JavaSourceBinaryOperator.of(
                    JavaSourceFieldReference.of(JavaSourceVariableReference.of("params"), "length"),
                    JavaSourceOperator.NOT_EQUAL,
                    JavaSourceLiteral.of(i)
            )).addStatement(JavaSourceThrowStatement.of(JavaSourceConstructorCall.of(JavaSourceNamespace.of(IllegalArgumentException.class).fill())
                    .addParameter(JavaSourceLiteral.of("Expected exactly " + i + " parameters")))));
            acceptArray.addStatement(acceptArrayCall);
            acceptArray.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            accept.addStatement(acceptCall);
            accept.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceMethod parameterCount = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.of(int.class).fill(), "parameterCount");
            parameterCount.addStatement(JavaSourceReturnStatement.of(JavaSourceLiteral.of(i)));
            parameterCount.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceInterfaceDefinition definition = new JavaSourceInterfaceDefinition(PACKAGE + ".Function" + i, generics);
            definition.addInterface(JavaSourceNamespace.of(FunctionX.class).fill(JavaSourceFilledGenerics.empty().addElement(JavaSourceFilledGenerics.Element.of(ret.fill())))).addInterface(dangerous.fill(dangerousFilled)).addModifier(JavaSourceModifier.PUBLIC)
                    .addMethod(call).addMethod(array).addMethod(acceptArray).addMethod(accept).addMethod(parameterCount);
            set.add(new JavaSourceFile(definition));
        }

        return set;
    }

    public static JavaSourceFileSet generateDangerousFunctions() {
        JavaSourceFileSet set = new JavaSourceFileSet();
        for (int i = 0; i < MAX_PARAMS; i++) {
            JavaSourceGenerics generics = JavaSourceGenerics.empty().set("R", Collections.emptyList());
            JavaSourceFilledGenerics consumerGenerics = JavaSourceFilledGenerics.empty();
            JavaSourceNamespace ret = JavaSourceNamespace.of("R", JavaSourceGenerics.empty(), false);
            JavaSourceMethodCall acceptCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "apply");
            generics.set("T", Arrays.asList(JavaSourceNamespace.of(Throwable.class).fill()));
            JavaSourceMethod call = JavaSourceMethod.of(JavaSourceGenerics.empty(), ret.fill(), "apply");
            JavaSourceMethod accept = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.VOID, "accept");
            JavaSourceMethodCall arrayCall = JavaSourceMethodCall.of(JavaSourceThisReference.of(), "apply");
            JavaSourceNamespace.Filled throwable = JavaSourceNamespace.of("T", JavaSourceGenerics.empty(), false).fill();
            consumerGenerics.addElement(JavaSourceFilledGenerics.Element.of(throwable));
            call.addThrowable(throwable);

            for (int j = 0; j < i; j++) {
                String name = "P" + (j + 1);
                JavaSourceNamespace namespace = JavaSourceNamespace.of(name, JavaSourceGenerics.empty(), false);
                generics.set(name, Collections.emptyList());
                consumerGenerics.addElement(JavaSourceFilledGenerics.Element.of(namespace.fill()));
                call.addParameter(JavaSourceParameter.of(namespace,
                        name.toLowerCase()));
                accept.addParameter(JavaSourceParameter.of(namespace,
                        name.toLowerCase()));
                acceptCall.addParameter(JavaSourceVariableReference.of(name.toLowerCase()));
                arrayCall.addParameter(JavaSourceCast.of(namespace, JavaSourceArrayGet.of(JavaSourceVariableReference.of("params"), JavaSourceLiteral.of(j))));
            }

            JavaSourceMethod array = JavaSourceMethod.of(JavaSourceGenerics.empty(), ret.fill(), "applyArray");
            array.addParameter(JavaSourceParameter.of(JavaSourceNamespace.of(Object[].class), "params", true));

            array.addStatement(JavaSourceIfBlock.ifBlock(JavaSourceBinaryOperator.of(
                    JavaSourceFieldReference.of(JavaSourceVariableReference.of("params"), "length"),
                    JavaSourceOperator.NOT_EQUAL,
                    JavaSourceLiteral.of(i)
            )).addStatement(JavaSourceThrowStatement.of(JavaSourceConstructorCall.of(JavaSourceNamespace.of(IllegalArgumentException.class).fill())
                    .addParameter(JavaSourceLiteral.of("Expected exactly " + i + " parameters")))));
            array.addStatement(JavaSourceReturnStatement.of(arrayCall));
            array.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));
            array.addThrowable(throwable);

            accept.addStatement(acceptCall);
            accept.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class)).addThrowable(throwable);

            JavaSourceMethod parameterCount = JavaSourceMethod.of(JavaSourceGenerics.empty(), JavaSourceNamespace.of(int.class).fill(), "parameterCount");
            parameterCount.addStatement(JavaSourceReturnStatement.of(JavaSourceLiteral.of(i)));
            parameterCount.addModifier(JavaSourceModifier.DEFAULT).addAnnotation(new JavaSourceAnnotation(Override.class));

            JavaSourceInterfaceDefinition definition = new JavaSourceInterfaceDefinition(PACKAGE + ".DangerousFunction" + i, generics);
            definition.addInterface(JavaSourceNamespace.of(DangerousFunctionX.class).fill(JavaSourceFilledGenerics.empty().addElement(JavaSourceFilledGenerics.Element.of(ret.fill())).addElement(JavaSourceFilledGenerics.Element.of(throwable))))
                    .addInterface(JavaSourceNamespace.of(PACKAGE + ".DangerousConsumer" + i, JavaSourceGenerics.empty(), false).fill(consumerGenerics))
                    .addModifier(JavaSourceModifier.PUBLIC)
                    .addMethod(call).addMethod(array).addMethod(accept).addMethod(parameterCount);
            set.add(new JavaSourceFile(definition));
        }

        return set;
    }

    public static void main(String[] args) throws IOException {
        File target = new File("src/main/java");
        generateConsumers().write(target);
        generateDangerousConsumers().write(target);
        generateFunctions().write(target);
        generateDangerousFunctions().write(target);
    }

}
