/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

/**
 *
 * @author repetto.francisco
 */
public class NodoArbol {
 
 //Atributos//
 private Object elem=null;
 private NodoArbol izquierdo=null;
 private NodoArbol derecho=null;
 
 //Constructores//
 public NodoArbol(Object elemento,NodoArbol zurdo,NodoArbol diestro){
     /*Constructor de Nodo Arbol*/
     elem=elemento;
     izquierdo=zurdo;
     derecho=diestro;
 }
 
 //Observadores//
 public Object getElem(){
     return this.elem;
 }
 
 public NodoArbol getIzquierdo(){
     return this.izquierdo;
 }
 
 public NodoArbol getDerecho(){
     return this.derecho;
 }
 
 //Modificadores//
 public void setElem(Object elemento){
    this.elem=elemento;
 }
 
 public void setIzquierdo(NodoArbol zurdo){
     this.izquierdo=zurdo;
 }
 
 public void setDerecho(NodoArbol diestro){
     this.derecho=diestro;
 }
}
