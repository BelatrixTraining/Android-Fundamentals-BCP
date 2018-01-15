# Android-Fundamentals - BCP
Curso de fundamentos de Android - Belatrix BCP

# Instructor

Eduardo José Medina Alfaro

e-mail: emedinaa@gmail.com

github: https://github.com/emedinaa

# Lesson2 

Entorno de desarrollo , componentes de una aplicación android y gradle.

## 1. Descarga el entorno de desarrollo

El IDE oficial para el desarrollo de apps en Android es Android Studio y la versión con la cual trabajaremos será 3.0. Pueden descargar este software para los diferentes sistemas operativos en este [link](https://developer.android.com/studio/index.html) , es importante verificar los requerimientos mínimos de sistema ya que AS tiene un alto consumo de recursos.
Adicional , para trabajar en Android es requerido tener instalado el JDK de Java , JDK 8 que puedes descargar en el siguiente [link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## 2. Crea tu primer proyecto Android

Desde android studio tenemos la opción :

File -> New -> New Project

Revisar los screenshots o en el [link](https://developer.android.com/training/basics/firstapp/creating-project.html?hl=es-419) (paso a paso) 

## 3. Trabaja sobre un proyecto base (template)

Todo el curso se va realizar con un proyecto template, con esto garantizamos que trabajemos sobre la misma configuración.
Abrir desde Android Studio el proyecto "BxTemplate"

File -> Open -> template/BxTemplate

## 4. Explora el entorno de desarrollo y revisa la estructura del proyecto

Al abrir un proyecto en Android Studio por primera vez debes explorar en entorno de desarrollo y el proyecto.

Explorar el entorno , guía de usuario [link](https://developer.android.com/studio/intro/index.html)

Explorar el proyecto ,

build.gradle del proyecto
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 15
    targetSdkVersion = 26
    compileSdkVersion = 26
    buildToolsVersion = '26.1.0'
    constraintLayoutVersion='1.0.2'

    // App dependencies
    supportLibraryVersion = '26.1.0'
    junitVersion = '4.12'
}

```

build.gradle de la app
```
apply plugin: 'com.android.application'

android {
    //compileSdkVersion 26
    compileSdkVersion rootProject.ext.compileSdkVersion

    defaultConfig {
        applicationId "com.belatrix.bxtemplate"

        //minSdkVersion 15
        minSdkVersion rootProject.ext.minSdkVersion

        //targetSdkVersion 26
        targetSdkVersion rootProject.ext.targetSdkVersion

        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    //implementation 'com.android.support:appcompat-v7:26.1.0'
    //implementation 'com.android.support.constraint:constraint-layout:1.0.2'

    implementation "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:support-v4:$rootProject.supportLibraryVersion"

    implementation "com.android.support:cardview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:design:$rootProject.supportLibraryVersion"
    implementation "com.android.support:recyclerview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"

    //testImplementation 'junit:junit:4.12'
    testImplementation "junit:junit:$rootProject.ext.junitVersion"

    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
}

```

## 5. Configura un emulador

Contamos con 3 opciones para poder probar nuestras aplicaciones 

- Crear un virtual device desde Android Studio , revisar el siguiente [link](https://developer.android.com/studio/run/emulator.html) 

- Usar Genymotion , [link](https://www.genymotion.com/desktop/)

- Trabajar directamente sobre un dispositivo físico

## 6. Ejecuta tu primer proyecto Android

Desde Android Studio tenemos las opción

Run -> run

# Referencias 

Entorno de desarrollo https://developer.android.com/studio/index.html?hl=es-419

Android Developers - Desarrollo https://developer.android.com/develop/index.html

Primer proyecto Android https://developer.android.com/training/basics/firstapp/creating-project.html?hl=es-419

Codelab - primera android app en Java https://codelabs.developers.google.com/codelabs/build-your-first-android-app/index.html?index=..%2F..%2Findex

Codelab - primera android app en Kotlin https://codelabs.developers.google.com/codelabs/build-your-first-android-app-kotlin/index.html?index=..%2F..%2Findex

Android Tool Time https://www.youtube.com/watch?v=0n9sBgds-Hs&list=PLWz5rJ2EKKc_w6fodMGrA1_tsI3pqPbqa

Canal oficial en Youtube para Android Developers https://www.youtube.com/user/androiddevelopers



