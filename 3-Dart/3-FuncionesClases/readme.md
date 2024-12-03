
### **Capítulo 3: Funciones y Clases**  


---

### **1. Funciones (30 minutos)**  

#### **¿Qué son las funciones?**  
- Son bloques de código reutilizables que realizan una tarea específica.  
- Pueden aceptar parámetros, devolver valores o no devolver nada (`void`).  

---

#### **Declaración y Uso de Funciones**  
1. **Sintaxis básica**:  
   ```dart
   int suma(int a, int b) {
     return a + b;
   }

   void main() {
     int resultado = suma(5, 3);
     print("La suma es: $resultado");
   }
   ```  

2. **Funciones sin valor de retorno (`void`)**:  
   ```dart
   void imprimirSaludo(String nombre) {
     print("Hola, $nombre");
   }
   ```  

3. **Funciones con valores predeterminados**:  
   - Usar valores predeterminados para los parámetros opcionales.  
     ```dart
     void saludar(String nombre, {String saludo = "Hola"}) {
       print("$saludo, $nombre");
     }

     void main() {
       saludar("Juan");
       saludar("Ana", saludo: "Buenos días");
     }
     ```  

4. **Funciones anónimas y Lambdas**:  
   - Usadas frecuentemente para operaciones rápidas o callbacks.  
     ```dart
     List<int> numeros = [1, 2, 3, 4];
     var cuadrados = numeros.map((n) => n * n).toList();
     print(cuadrados); // [1, 4, 9, 16]
     ```  

---

#### **Ámbito de Variables en Funciones**  
- Variables locales: Declaradas dentro de una función.  
- Variables globales: Declaradas fuera de cualquier función y accesibles en toda la aplicación.  
  ```dart
  int global = 10;

  void imprimirGlobal() {
    print(global); // 10
  }
  ```  

---

#### **Actividad Práctica**  
1. Crear una función que reciba un número y retorne su factorial.  
2. Crear una función que reciba una lista de nombres y devuelva los que empiezan con una letra específica.  

**Código ejemplo**:  
```dart
int factorial(int n) {
  if (n <= 1) return 1;
  return n * factorial(n - 1);
}

List<String> filtrarPorLetra(List<String> nombres, String letra) {
  return nombres.where((nombre) => nombre.startsWith(letra)).toList();
}

void main() {
  print("Factorial de 5: ${factorial(5)}");

  List<String> nombres = ["Ana", "Juan", "Pedro", "Paula"];
  print(filtrarPorLetra(nombres, "P")); // ["Pedro", "Paula"]
}
```

---

### **2. Clases (30 minutos)**  

#### **¿Qué son las clases?**  
- Una clase es una plantilla que define la estructura y comportamiento de un objeto.  
- Un objeto es una instancia de una clase.  

---

#### **Declaración y Uso de Clases**  
1. **Declarar una Clase**:  
   ```dart
   class Persona {
     String nombre;
     int edad;

     // Constructor
     Persona(this.nombre, this.edad);

     // Método
     void saludar() {
       print("Hola, soy $nombre y tengo $edad años");
     }
   }

   void main() {
     Persona persona = Persona("Juan", 30);
     persona.saludar();
   }
   ```  

2. **Constructores Nombrados y Parámetros Opcionales**:  
   - Crear diferentes formas de inicializar un objeto.  
     ```dart
     class Persona {
       String nombre;
       int edad;

       // Constructor estándar
       Persona(this.nombre, this.edad);

       // Constructor nombrado
       Persona.soloNombre(this.nombre) : edad = 0;

       void saludar() {
         print("Hola, soy $nombre y tengo $edad años");
       }
     }

     void main() {
       Persona persona1 = Persona("Ana", 25);
       Persona persona2 = Persona.soloNombre("Luis");

       persona1.saludar(); // Hola, soy Ana y tengo 25 años
       persona2.saludar(); // Hola, soy Luis y tengo 0 años
     }
     ```  

3. **Atributos y Métodos**:  
   - Atributos: Propiedades de una clase.  
   - Métodos: Funciones definidas dentro de una clase.  

4. **Getters y Setters**:  
   - Controlar el acceso y modificación de atributos.  
     ```dart
     class Rectangulo {
       double _ancho, _alto;

       Rectangulo(this._ancho, this._alto);

       double get area => _ancho * _alto;

       set ancho(double valor) {
         if (valor > 0) _ancho = valor;
       }
     }

     void main() {
       Rectangulo rect = Rectangulo(5, 10);
       print("Área: ${rect.area}");
       rect.ancho = 8;
       print("Área después de cambio: ${rect.area}");
     }
     ```  

---

#### **Herencia y Polimorfismo**  
1. **Herencia**:  
   - Una clase puede heredar atributos y métodos de otra clase.  
     ```dart
     class Animal {
       void sonido() {
         print("El animal hace un sonido");
       }
     }

     class Perro extends Animal {
       @override
       void sonido() {
         print("El perro ladra");
       }
     }

     void main() {
       Perro perro = Perro();
       perro.sonido(); // El perro ladra
     }
     ```  

2. **Polimorfismo**:  
   - Capacidad de usar una clase base para referirse a una clase derivada.  

---

#### **Actividad Práctica**  
1. Crear una clase `Coche` con atributos como marca, modelo y un método para arrancar el coche.  
2. Crear una clase `Empleado` que herede de una clase base `Persona` y agregue un método para calcular el salario anual.  

**Código ejemplo**:  
```dart
class Persona {
  String nombre;
  Persona(this.nombre);

  void presentarse() {
    print("Hola, soy $nombre");
  }
}

class Empleado extends Persona {
  double salario;

  Empleado(String nombre, this.salario) : super(nombre);

  double calcularSalarioAnual() {
    return salario * 12;
  }
}

void main() {
  Empleado empleado = Empleado("Ana", 1500);
  empleado.presentarse();
  print("Salario anual: ${empleado.calcularSalarioAnual()}");
}
```

---
