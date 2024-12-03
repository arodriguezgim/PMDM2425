
### **Capítulo 4: Futures y Async-Await**  


---

### **1. Introducción a Futures (30 minutos)**  

#### **¿Qué es un Future?**  
- **Future** es un objeto que representa una operación asincrónica cuyo resultado estará disponible en el futuro.  
- Se utiliza para manejar operaciones que pueden tardar un tiempo, como leer archivos, hacer solicitudes HTTP o acceder a bases de datos.  

---

#### **Sintaxis de un Future**  
1. **Crear y Usar un Future**:  
   ```dart
   Future<String> obtenerMensaje() {
     return Future.delayed(Duration(seconds: 2), () {
       return "Hola desde el futuro";
     });
   }

   void main() {
     obtenerMensaje().then((mensaje) {
       print(mensaje); // Se ejecuta después de 2 segundos
     });
   }
   ```  

2. **Métodos importantes de Future**:  
   - **then**: Para procesar el resultado del Future.  
   - **catchError**: Para manejar errores.  
   - **whenComplete**: Para ejecutar código cuando el Future se completa, independientemente de si tuvo éxito o falló.  

   Ejemplo:  
   ```dart
   Future<int> dividir(int a, int b) {
     return Future(() {
       if (b == 0) throw Exception("División por cero");
       return a ~/ b;
     });
   }

   void main() {
     dividir(10, 0)
         .then((resultado) => print("Resultado: $resultado"))
         .catchError((e) => print("Error: $e"))
         .whenComplete(() => print("Operación completada"));
   }
   ```  

---

### **2. Async-Await (30 minutos)**  

#### **¿Qué es Async-Await?**  
- **async** y **await** son palabras clave que hacen que el código asíncrono parezca síncrono, lo que facilita su lectura.  
- **async**: Marca una función como asíncrona, permitiéndole usar **await**.  
- **await**: Pausa la ejecución de la función hasta que un Future se complete.  

---

#### **Ejemplo básico de Async-Await**  
```dart
Future<String> obtenerDatos() async {
  return Future.delayed(Duration(seconds: 3), () => "Datos cargados");
}

void main() async {
  print("Cargando...");
  String datos = await obtenerDatos();
  print(datos); // "Datos cargados"
}
```  

---

#### **Manejo de Errores con Try-Catch**  
- Puedes usar **try-catch** para capturar errores en funciones asíncronas.  
```dart
Future<int> dividir(int a, int b) async {
  if (b == 0) throw Exception("División por cero");
  return a ~/ b;
}

void main() async {
  try {
    int resultado = await dividir(10, 0);
    print("Resultado: $resultado");
  } catch (e) {
    print("Error: $e");
  }
}
```  

---

#### **Operaciones Concurrentes con `Future.wait`**  
- **Future.wait** permite ejecutar múltiples Futures en paralelo y esperar a que todos se completen.  
```dart
Future<String> tarea1() async {
  return Future.delayed(Duration(seconds: 2), () => "Tarea 1 completada");
}

Future<String> tarea2() async {
  return Future.delayed(Duration(seconds: 1), () => "Tarea 2 completada");
}

void main() async {
  print("Ejecutando tareas...");
  var resultados = await Future.wait([tarea1(), tarea2()]);
  print(resultados); // ["Tarea 1 completada", "Tarea 2 completada"]
}
```  

---

#### **Simulación de una Solicitud HTTP**  
Usando el paquete `dart:async`, puedes simular la carga de datos desde una API.  
```dart
Future<String> obtenerUsuario() async {
  print("Obteniendo usuario...");
  return Future.delayed(Duration(seconds: 3), () => "Usuario: Juan Pérez");
}

void main() async {
  print("Iniciando solicitud...");
  String usuario = await obtenerUsuario();
  print(usuario);
}
```  

---

### **Actividades Prácticas (10 minutos)**  

1. **Cargar datos simulados**  
   - Escribe una función que simule la carga de datos desde una base de datos y devuelva una lista de nombres después de 2 segundos.  

   **Ejemplo**:  
   ```dart
   Future<List<String>> cargarNombres() async {
     return Future.delayed(Duration(seconds: 2), () => ["Ana", "Luis", "Pedro"]);
   }

   void main() async {
     print("Cargando nombres...");
     var nombres = await cargarNombres();
     print("Nombres cargados: $nombres");
   }
   ```  

2. **Simular una operación concurrente**  
   - Crea tres tareas asíncronas (simuladas con `Future.delayed`) que devuelvan resultados. Usa `Future.wait` para ejecutarlas todas en paralelo y mostrar el resultado cuando todas estén listas.  

   **Ejemplo**:  
   ```dart
   Future<int> tarea1() => Future.delayed(Duration(seconds: 2), () => 10);
   Future<int> tarea2() => Future.delayed(Duration(seconds: 3), () => 20);
   Future<int> tarea3() => Future.delayed(Duration(seconds: 1), () => 30);

   void main() async {
     print("Iniciando tareas...");
     var resultados = await Future.wait([tarea1(), tarea2(), tarea3()]);
     print("Resultados: $resultados"); // [10, 20, 30]
   }
   ```  

3. **Captura de errores en tareas concurrentes**  
   - Modifica el ejercicio anterior para que una de las tareas lance un error, y maneja ese error adecuadamente usando `try-catch`.

---

### **Resumen y Conceptos Clave**  
- Un **Future** representa una tarea asincrónica.
- Usa **then** y **catchError** para manejar resultados y errores.
- Con **async/await**, puedes escribir código más legible para manejar tareas asincrónicas.
- Maneja errores con **try-catch** en funciones asíncronas.
- Usa **Future.wait** para manejar múltiples operaciones concurrentes.

---
