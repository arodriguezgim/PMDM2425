## ¿Qué es el ViewModel?

`ViewModel` es una clase proporcionada por Android que ayuda a gestionar y almacenar datos relacionados con la interfaz de usuario de forma que sobrevivan a cambios de configuración, como rotaciones de pantalla. Forma parte de la **Android Architecture Components** y su objetivo es separar la lógica de la UI del código de la actividad o fragmento, promoviendo el patrón **MVVM** (Model-View-ViewModel).

### Ventajas de usar ViewModel
- **Persistencia**: Mantiene los datos de la UI al rotar la pantalla o en otras configuraciones.
- **Encapsulamiento**: La lógica de datos está fuera de la vista (Activity/Fragment).
- **Vida útil controlada**: Su ciclo de vida está asociado a un `Activity` o `Fragment`, pero no se reinicia en cambios de configuración.

## ¿Qué es LiveData?

`LiveData` es una clase que contiene datos que pueden ser observados. Es consciente del ciclo de vida, lo que significa que solo notifica a los observadores activos (como un `Activity` o `Fragment`) que están en un estado adecuado para recibir actualizaciones, lo que ayuda a evitar errores comunes en el ciclo de vida.

### Ventajas de usar LiveData
- **Reactividad**: Actualiza automáticamente los observadores cuando los datos cambian.
- **Consciente del ciclo de vida**: Solo envía datos a los observadores cuando están en un estado activo.
- **Sin fugas de memoria**: Las actualizaciones solo ocurren cuando el `Activity` o `Fragment` está en un estado seguro.

## Implementación de ViewModel con LiveData

### Paso 1: Añadir dependencias

Asegúrate de tener las dependencias en tu archivo `build.gradle` (module):

```gradle
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.1'
```

### Paso 2: Crear la clase ViewModel

Define una clase que extienda `ViewModel`. En ella, puedes declarar propiedades `LiveData` para que los datos se puedan observar en la UI:

```kotlin
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    // Datos internos que se pueden modificar
    private val _texto = MutableLiveData<String>()
    
    // LiveData externo que puede observarse
    val texto: LiveData<String> get() = _texto

    // Método para actualizar el valor de _texto
    fun actualizarTexto(nuevoTexto: String) {
        _texto.value = nuevoTexto
    }
}
```

### Paso 3: Usar ViewModel en un Activity o Fragment

#### En un Activity

1. Crea una instancia del `ViewModel` utilizando `ViewModelProvider`.
2. Observa los cambios en los datos de `LiveData`.

```kotlin
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observa el LiveData para actualizar la UI cuando cambien los datos
        myViewModel.texto.observe(this, Observer { nuevoTexto ->
            binding.textView.text = nuevoTexto
        })

        // Ejemplo de actualización de datos en el ViewModel
        binding.buttonActualizar.setOnClickListener {
            myViewModel.actualizarTexto("Nuevo texto!")
        }
    }
}
```

#### En un Fragment

El proceso es similar, solo que utilizamos `viewModels()` dentro del fragmento:

```kotlin
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.app.databinding.FragmentExampleBinding

class ExampleFragment : Fragment() {

    private var _binding: FragmentExampleBinding? = null
    private val binding get() = _binding!!
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observa el LiveData para actualizar la UI cuando cambien los datos
        myViewModel.texto.observe(viewLifecycleOwner, Observer { nuevoTexto ->
            binding.textView.text = nuevoTexto
        })

        // Ejemplo de actualización de datos en el ViewModel
        binding.buttonActualizar.setOnClickListener {
            myViewModel.actualizarTexto("Texto actualizado desde el fragmento!")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
```

### Resumen

1. **ViewModel** permite que los datos persistan durante cambios de configuración.
2. **LiveData** es una clase de datos reactiva que notifica a los observadores activos de cambios.
3. **viewModels**: Crea una instancia de ViewModel en Activity o Fragment.
4. **Observer**: Observa `LiveData` y actualiza la UI cuando los datos cambian.

