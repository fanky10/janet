package io.techery.janet;

import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;

import io.techery.janet.compiler.utils.ActionClass;
import io.techery.janet.compiler.utils.Generator;

public class AsyncWrappersGenerator extends Generator<AsyncActionClass> {

    protected AsyncWrappersGenerator(Filer filer) {
        super(filer);
    }

    @Override public void generate(ArrayList<AsyncActionClass> actionClasses) {
        for (ActionClass actionClass : actionClasses) {
            generate(actionClass);
        }
    }

    private void generate(ActionClass actionClass) {
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(actionClass.getWrapperName())
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc("Janet compile time, autogenerated class");


        saveClass(actionClass.getPackageName(), classBuilder.build());
    }

}
