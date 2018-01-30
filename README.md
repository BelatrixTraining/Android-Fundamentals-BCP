# Android-Fundamentals - BCP
Curso de fundamentos de Android - Belatrix BCP

# Instructor

Eduardo José Medina Alfaro

e-mail: emedinaa@gmail.com

github: https://github.com/emedinaa

# Lesson 6 

 Comunicación entre pantallas, intents, dialogs y notificaciones.
 
 Ciclo de Vida de un Actividad
 
 ![img](https://developer.android.com/guide/components/images/activity_lifecycle.png)
 
 
 Flujo de una Aplicación
 
 ![img](https://developer.android.com/images/training/app-navigation-wireframing-wires-phone.png)
 
 Comunicación entre Actividades :
 
 Tenemos 2 pantallas: SplashActivity y LogInActivity , y requerimos ir de la primera pantalla y la segunda pantalla.
 Lo primero es crear un intent, donde indicamos en que vista estamos (this) y a que pantalla queremos ir (LogInActivity.class)
 
 ```java
     Intent intent= new Intent(this,LogInActivity.class);
     startActivity(intent);
     finish();
 ```

# Referencias 

Activities https://developer.android.com/guide/components/activities/index.html

Building Your First App https://developer.android.com/training/basics/firstapp/index.html?hl=en

Dialogs https://developer.android.com/guide/topics/ui/dialogs.html?hl=en

Material Design - Dialogs https://material.io/guidelines/components/dialogs.html

Notifications https://developer.android.com/guide/topics/ui/notifiers/notifications.html

Building a Notification https://developer.android.com/training/notify-user/build-notification.html

Android Dev Intents https://developer.android.com/reference/android/content/Intent.html

Common Intents https://developer.android.com/guide/components/intents-common.html?hl=en-419

Intents and Intent Filters https://developer.android.com/guide/components/intents-filters.html?hl=en-419

Designing effective navigation https://developer.android.com/training/design-navigation/index.html
