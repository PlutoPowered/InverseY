/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 socraticphoenix@gmail.com
 * Copyright (c) 2016 contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.gmail.socraticphoenix.inversey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
class InternalFunctionGenerator {

    public static void main(String[] args) throws IOException {
        File dir = new File(args[0]);
        dir.mkdir();

        String function = "/*\n" +
                " * This file is an auto-generated element of InverseY\n" +
                " */\n" +
                "package com.gmail.socraticphoenix.inversey.many;\n" +
                "\n" +
                "public interface Function${number}<${generics}, R> extends Consumer${number}<${generics}>, DangerousConsumer${number}<${generics}, RuntimeException>, DangerousFunction${number}<${generics}, R, RuntimeException> {\n" +
                "\n" +
                "    R invoke(${params});\n\n" +
                "    @Override\n" +
                "    default <T extends Throwable> DangerousFunction${number}<${generics}, R, T> cast() {\n" +
                "        return (DangerousFunction${number}<${generics}, R, T>) this;\n" +
                "    }\n\n" +
                "    @Override\n" +
                "    default void call(${params}) {\n" +
                "        this.invoke(${args});\n" +
                "    }\n" +
                "\n" +
                "}\n";
        String consumer = "/*\n" +
                " * This file is an auto-generated element of InverseY\n" +
                " */\n" +
                "package com.gmail.socraticphoenix.inversey.many;\n" +
                "\n" +
                "public interface Consumer${number}<${generics}> extends DangerousConsumer${number}<${generics}, RuntimeException> {\n" +
                "\n" +
                "    void call(${params});\n\n" +
                "    default <T extends Throwable> DangerousConsumer${number}<${generics}, T> cast() {\n" +
                "        return (DangerousConsumer${number}<${generics}, T>) this;\n" +
                "    }" +
                "\n" +
                "}";

        String dfunction = "/*\n" +
                " * This file is an auto-generated element of InverseY\n" +
                " */\n" +
                "package com.gmail.socraticphoenix.inversey.many;\n" +
                "\n" +
                "public interface DangerousFunction${number}<${generics}, R, T extends Throwable> extends DangerousConsumer${number}<${generics}, T> {\n" +
                "\n" +
                "    R invoke(${params}) throws T;\n" +
                "\n" +
                "    @Override\n" +
                "    default void call(${params}) throws T {\n" +
                "        this.invoke(${args});\n" +
                "    }\n" +
                "\n" +
                "}\n";
        String dconsumer = "/*\n" +
                " * This file is an auto-generated element of InverseY\n" +
                " */\n" +
                "package com.gmail.socraticphoenix.inversey.many;\n" +
                "\n" +
                "public interface DangerousConsumer${number}<${generics}, T extends Throwable> {\n" +
                "\n" +
                "    void call(${params}) throws T;\n" +
                "\n" +
                "}";

        for (int i = 1; i <= 254; i++) {
            StringBuilder generics = new StringBuilder();
            StringBuilder params = new StringBuilder();
            StringBuilder arguments = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                generics.append("P").append(j);
                arguments.append("p").append(j);
                params.append("P").append(j).append(" ").append("p").append(j);
                if(j < i) {
                    generics.append(", ");
                    params.append(", ");
                    arguments.append(", ");
                }
            }

            if(i > 2) {
                String createdFunction = function.replaceAll(Pattern.quote("${number}"), String.valueOf(i))
                        .replaceAll(Pattern.quote("${generics}"), generics.toString())
                        .replaceAll(Pattern.quote("${params}"), params.toString())
                        .replaceAll(Pattern.quote("${args}"), arguments.toString());
                String createdConsumer = consumer.replaceAll(Pattern.quote("${number}"), String.valueOf(i))
                        .replaceAll(Pattern.quote("${generics}"), generics.toString())
                        .replaceAll(Pattern.quote("${params}"), params.toString())
                        .replaceAll(Pattern.quote("${args}"), arguments.toString());
                FileWriter writer = new FileWriter(new File(dir, "Function" + i + ".java"));
                writer.write(createdFunction);
                writer.close();
                FileWriter writer2 = new FileWriter(new File(dir, "Consumer" + i + ".java"));
                writer2.write(createdConsumer);
                writer2.close();
            }

            String dcreatedConsumer = dconsumer.replaceAll(Pattern.quote("${number}"), String.valueOf(i))
                    .replaceAll(Pattern.quote("${generics}"), generics.toString())
                    .replaceAll(Pattern.quote("${params}"), params.toString())
                    .replaceAll(Pattern.quote("${args}"), arguments.toString());
            String dcreatedFunction = dfunction.replaceAll(Pattern.quote("${number}"), String.valueOf(i))
                    .replaceAll(Pattern.quote("${generics}"), generics.toString())
                    .replaceAll(Pattern.quote("${params}"), params.toString())
                    .replaceAll(Pattern.quote("${args}"), arguments.toString());
            FileWriter writer3 = new FileWriter(new File(dir, "DangerousConsumer" + i + ".java"));
            writer3.write(dcreatedConsumer);
            writer3.close();
            FileWriter writer4 = new FileWriter(new File(dir, "DangerousFunction" + i + ".java"));
            writer4.write(dcreatedFunction);
            writer4.close();
        }
    }

}
