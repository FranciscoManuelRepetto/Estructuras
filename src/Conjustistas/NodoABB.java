/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjustistas;

/**
 *
 * @author repetto.francisco
 */
public class NodoABB {
    //Atributos//
 private Comparable elem=null;
 private NodoABB izquierdo=null;
 private NodoABB derecho=null;
 
 //Constructores//
 public NodoABB(Comparable elemento,NodoABB zurdo,NodoABB diestro){
     /*Constructor de Nodo Arbol*/
     elem=elemento;
     izquierdo=zurdo;
     derecho=diestro;
 }
 
 //Observadores//
 public Comparable getElem(){
     return this.elem;
 }
 
 public NodoABB getIzquierdo(){
     return this.izquierdo;
 }
 
 public NodoABB getDerecho(){
     return this.derecho;
 }
 
 //Modificadores//
 public void setElem(Comparable elemento){
    this.elem=elemento;
 }
 
 public void setIzquierdo(NodoABB zurdo){
     this.izquierdo=zurdo;
 }
 
 public void setDerecho(NodoABB diestro){
     this.derecho=diestro;
 }
}

