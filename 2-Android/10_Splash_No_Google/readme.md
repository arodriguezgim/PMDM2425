Para crear una **SplashScreen** en Android usando la nueva biblioteca `core-splashscreen` de `androidx`, el proceso es mucho más sencillo y eficiente que configurarla manualmente. Esta biblioteca gestiona automáticamente el tiempo de visualización de la pantalla de inicio y permite personalizar algunas animaciones de transición.

### Paso 1: Configura la Dependencia

Asegúrate de añadir la dependencia en tu archivo `build.gradle` de tu módulo de aplicación:

```gradle
implementation("androidx.core:core-splashscreen:1.0.0")
```

### Paso 2: Configura el tema de la SplashScreen

En el archivo `res/values/themes.xml`, añade un tema para la `SplashScreen` que incluya un `windowBackground` con la imagen o color de fondo de tu pantalla de bienvenida:

```xml
<!-- Tema de la SplashScreen -->
<style name="Theme.MyApp.Splash" parent="Theme.SplashScreen">
    <!-- Imagen de fondo para la SplashScreen -->
    <item name="windowSplashScreenBackground">@color/white</item>
    <!-- Icono o imagen del logo de la aplicación -->
    <item name="windowSplashScreenAnimatedIcon">@drawable/logo</item>
    <!-- Duración de la animación del ícono -->
    <item name="windowSplashScreenAnimationDuration">3000</item>
    <!-- Color de fondo para la MainActivity -->
    <item name="postSplashScreenTheme">@style/Theme.MyApp</item>
</style>
```

- `windowSplashScreenBackground`: define el color o imagen de fondo para la **SplashScreen**.
- `windowSplashScreenAnimatedIcon`: especifica el ícono o logo que quieres mostrar en la pantalla de inicio.
- `windowSplashScreenAnimationDuration`: define la duración de la animación en milisegundos (3 segundos en este caso).
- `postSplashScreenTheme`: define el tema que usará la aplicación después de la **SplashScreen**.

### Paso 3: Aplica el tema a tu `SplashActivity`

En el archivo `AndroidManifest.xml`, especifica que el `SplashActivity` debe usar el tema de la `SplashScreen`:

```xml
<application
    ... >
    <activity
        android:name=".SplashActivity"
        android:theme="@style/Theme.MyApp.Splash"
        android:exported="true">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>

    <activity android:name=".MainActivity" />
</application>
```

### Paso 4: Implementa `SplashActivity` para iniciar la `MainActivity`

Crea la clase `SplashActivity` que utilizará la nueva API de `core-splashscreen` para gestionar la pantalla de bienvenida:

```kotlin
package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Instala la pantalla de bienvenida
        val splashScreen = SplashScreen.installSplashScreen(this)
        
        super.onCreate(savedInstanceState)

        // Inicia la MainActivity después de mostrar la SplashScreen
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
```

### Explicación Final

Esta implementación usará la API `SplashScreen.installSplashScreen()` para activar la `SplashScreen` automáticamente antes de mostrar la `MainActivity`. La duración de la pantalla y su animación están determinadas por los valores en el tema de `Theme.MyApp.Splash`. Después de los 3 segundos, la aplicación abrirá `MainActivity`.


---
Desde Android 12 en adelante, Google ha integrado un sistema de **Splash Screen API** que facilita el diseño y la implementación de una pantalla de bienvenida. Te dejo una guía secuencial para agregar un splash screen con esta nueva API:

### Guía para agregar un Splash Screen en Android

1. **Configura tu tema para el Splash Screen**:
   En tu archivo `res/values/styles.xml`, define un tema específico para el splash screen. Este tema debería incluir un fondo de pantalla que represente el splash. Por ejemplo:

   ```xml
   <style name="Theme.MyApp.Splash" parent="Theme.SplashScreen">
       <!-- Imagen para el splash screen -->
       <item name="windowSplashScreenBackground">@color/white</item>
       <item name="windowSplashScreenAnimatedIcon">@drawable/splash_image</item>
       <!-- Duración del splash screen (opcional) -->
       <item name="windowSplashScreenDuration">1000</item>
       <!-- Personalización del ícono -->
       <item name="postSplashScreenTheme">@style/Theme.MyApp</item>
   </style>
   ```

2. **Actualiza tu archivo `AndroidManifest.xml`**:
   Establece el tema del splash screen en la actividad principal de tu aplicación en el archivo `AndroidManifest.xml`:

   ```xml
   <application
       ...>
       <activity
           android:name=".MainActivity"
           android:theme="@style/Theme.MyApp.Splash">
           <intent-filter>
               <action android:name="android.intent.action.MAIN" />
               <category android:name="android.intent.category.LAUNCHER" />
           </intent-filter>
       </activity>
   </application>
   ```

3. **Configura la actividad principal para el Splash Screen**:
   En tu `MainActivity`, llama a la función `installSplashScreen()` para iniciar la API del splash screen. Esto se hace al principio de la actividad, en `onCreate`.

   ```kotlin
   import android.os.Bundle
   import androidx.appcompat.app.AppCompatActivity
   import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

   class MainActivity : AppCompatActivity() {
       override fun onCreate(savedInstanceState: Bundle?) {
           // Instala el Splash Screen
           val splashScreen = installSplashScreen()

           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
       }
   }
   ```

4. **Opcional: Ajusta la duración del Splash Screen**:
   Si necesitas mantener el splash screen visible durante más tiempo (por ejemplo, para cargar datos), puedes hacer que la pantalla se mantenga hasta que completes la tarea:

   ```kotlin
   splashScreen.setKeepOnScreenCondition {
       // Mantener la pantalla de splash visible hasta que se complete una condición
       viewModel.isDataLoaded.value == false
   }
   ```

### Detalles adicionales:

- La **propiedad `windowSplashScreenDuration`** en `styles.xml` controla el tiempo mínimo que se muestra el splash screen.
- Asegúrate de configurar la imagen en varias densidades en las carpetas `drawable` para que Android ajuste automáticamente según el dispositivo, como te explicaba anteriormente.

Esta guía debería darte un splash screen funcional y personalizable con la nueva **Splash Screen API**.