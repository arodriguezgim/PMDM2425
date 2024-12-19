import 'package:contador_01/presentation/screens/counter_functions_screen.dart';
import 'package:contador_01/presentation/screens/counter_screen.dart';
import 'package:flutter/material.dart';

void main(){
  runApp( MyApp() );
}

class MyApp extends StatelessWidget{
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData.light(),
      debugShowCheckedModeBanner: false,
      home: CounterFunctionsScreen()
    );
  }

}