import 'package:flutter/material.dart';

class CounterScreen extends StatefulWidget {
  const CounterScreen({super.key});

  @override
  State<CounterScreen> createState() => _CounterScreenState();
}

class _CounterScreenState extends State<CounterScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('Contador'),
        centerTitle: true,
        backgroundColor: Colors.purple.shade100
      ),
      body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('$contador', style: TextStyle(fontSize: 160, fontWeight: FontWeight.w100),),
                Text('Clicks', style: TextStyle(fontSize: 30),),
              ],
            ),
          ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: (){
          
          setState(() {
            contador++;
          });
        }
        ),
      );
  }
}