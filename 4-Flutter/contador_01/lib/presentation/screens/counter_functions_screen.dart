import 'package:flutter/material.dart';

class CounterFunctionsScreen extends StatefulWidget {
  const CounterFunctionsScreen({super.key});

  @override
  State<CounterFunctionsScreen> createState() => _CounterScreenState();
}

class _CounterScreenState extends State<CounterFunctionsScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('Contador Completo'),
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
      //floatingActionButtonLocation: FloatingActionButtonLocation.startTop,
      floatingActionButton: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
            child: Icon(Icons.refresh_rounded),
            onPressed: (){
              
              setState(() {
                contador = 0;
              });
            }
            ),
          SizedBox(height: 10,),
          FloatingActionButton(
            child: Icon(Icons.exposure_minus_1_outlined),
            onPressed: (){
              
              setState(() {
                contador--;
              });
            }
            ),
          SizedBox(height: 10,),
          FloatingActionButton(
            child: Icon(Icons.plus_one_outlined),
            onPressed: (){
              
              setState(() {
                contador++;
              });
            }
            ),
        ],
      )
      );
  }
}