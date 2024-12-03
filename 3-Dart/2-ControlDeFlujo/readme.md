
### **Capítulo 2: Control de Flujo y Estructuras Básicas**  


---

### **1. Estructuras de Control (20 min)**  

#### **Condicionales**  
1. **if/else**  
   - Uso básico de condicionales:  
     ```dart
     int edad = 18;
     if (edad >= 18) {
       print("Eres mayor de edad");
     } else {
       print("Eres menor de edad");
     }
     ```
   - **else if** para múltiples condiciones:  
     ```dart
     int calificacion = 85;
     if (calificacion >= 90) {
       print("Excelente");
     } else if (calificacion >= 75) {
       print("Aprobado");
     } else {
       print("Reprobado");
     }
     ```  

2. **switch/case**  
   - Uso cuando hay múltiples valores posibles:  
     ```dart
     String dia = "lunes";
     switch (dia) {
       case "lunes":
         print("Inicio de la semana");
         break;
       case "viernes":
         print("Casi fin de semana");
         break;
       case "sábado":
       case "domingo":
         print("Es fin de semana");
         break;
       default:
         print("Día no reconocido");
     }
     ```  
   - **Nota**: `switch` en Dart admite números, cadenas y enums como casos.  

#### **Bucles**  
1. **for**  
   - Iterar sobre un rango de números:  
     ```dart
     for (int i = 0; i < 5; i++) {
       print("Iteración $i");
     }
     ```  
   - Iterar sobre listas:  
     ```dart
     List<String> frutas = ["Manzana", "Banana", "Naranja"];
     for (String fruta in frutas) {
       print(fruta);
     }
     ```  

2. **while y do-while**  
   - **while**: Se ejecuta mientras la condición sea verdadera.  
     ```dart
     int contador = 0;
     while (contador < 3) {
       print("Contador: $contador");
       contador++;
     }
     ```  
   - **do-while**: Se ejecuta al menos una vez antes de verificar la condición.  
     ```dart
     int contador = 0;
     do {
       print("Contador: $contador");
       contador++;
     } while (contador < 3);
     ```  

3. **break y continue**  
   - **break**: Sale del bucle inmediatamente.  
     ```dart
     for (int i = 0; i < 5; i++) {
       if (i == 3) break;
       print("Número: $i");
     }
     ```  
   - **continue**: Salta a la siguiente iteración.  
     ```dart
     for (int i = 0; i < 5; i++) {
       if (i == 3) continue;
       print("Número: $i");
     }
     ```  

---

### **2. Listas y Mapas (20 min)**  

#### **Listas (`List`)**  
1. **Declaración y Operaciones Básicas**  
   - Crear una lista:  
     ```dart
     List<int> numeros = [1, 2, 3, 4, 5];
     print(numeros); // [1, 2, 3, 4, 5]
     ```  
   - Acceso por índice:  
     ```dart
     print(numeros[2]); // 3
     ```  
   - Agregar elementos:  
     ```dart
     numeros.add(6);
     print(numeros); // [1, 2, 3, 4, 5, 6]
     ```  
   - Eliminar elementos:  
     ```dart
     numeros.remove(3); // Elimina el valor 3
     print(numeros); // [1, 2, 4, 5, 6]
     ```  

2. **Recorrer una Lista**  
   - Usando un bucle:  
     ```dart
     for (int numero in numeros) {
       print(numero);
     }
     ```  

3. **Listas dinámicas y vacías**  
   - Crear una lista vacía:  
     ```dart
     List<String> nombres = [];
     nombres.add("Juan");
     print(nombres); // ["Juan"]
     ```  

#### **Mapas (`Map`)**  
1. **Declaración y Operaciones Básicas**  
   - Crear un mapa:  
     ```dart
     Map<String, int> edades = {
       "Juan": 25,
       "Ana": 30,
       "Luis": 20
     };
     print(edades["Ana"]); // 30
     ```  
   - Agregar y eliminar elementos:  
     ```dart
     edades["Pedro"] = 40; // Agregar
     edades.remove("Luis"); // Eliminar
     print(edades); // {"Juan": 25, "Ana": 30, "Pedro": 40}
     ```  

2. **Recorrer un Mapa**  
   - Usando un bucle:  
     ```dart
     for (var entrada in edades.entries) {
       print("${entrada.key} tiene ${entrada.value} años");
     }
     ```  

3. **Operaciones útiles**  
   - Verificar si una clave existe:  
     ```dart
     if (edades.containsKey("Ana")) {
       print("Ana está en el mapa");
     }
     ```  
   - Obtener todas las claves o valores:  
     ```dart
     print(edades.keys); // ("Juan", "Ana", "Pedro")
     print(edades.values); // (25, 30, 40)
     ```  

---

### **Ejemplo Integrador (5 min)**  

Escribe un programa que:  
1. Cree una lista de números enteros del 1 al 10.  
2. Calcule la suma de los números impares en la lista.  
3. Cree un mapa que relacione nombres de estudiantes con sus notas.  

**Código ejemplo**:  
```dart
void main() {
  // 1. Crear y sumar números impares
  List<int> numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  int sumaImpares = numeros.where((n) => n % 2 != 0).reduce((a, b) => a + b);
  print("Suma de impares: $sumaImpares");

  // 2. Crear un mapa de estudiantes
  Map<String, double> estudiantes = {
    "Juan": 8.5,
    "Ana": 9.2,
    "Luis": 7.8
  };

  estudiantes.forEach((nombre, nota) {
    print("$nombre tiene una nota de $nota");
  });
}
```  

---

### **Actividades Prácticas (5 min)**  
1. Crear un programa que imprima todos los números del 1 al 20, excepto los múltiplos de 3.  
2. Crear un mapa para almacenar nombres de productos y sus precios, luego calcular el precio total de todos los productos.  

---
