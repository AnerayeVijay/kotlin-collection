# kotlin-collection
## Introduction
- Collections are used to store a group of related Objects in memory.Kotlin inherits collections framework from Java, but has significant changes from it in favor of functional programming. In this article, we are going to discuss the collections framework and collection operations in Kotlin.
- The collections framework in Kotlin  is more functional than Java, it is easier to use and understand.
- The collections framework is a set of classes and interfaces that provides a unified architecture for performing common groups of data related operations, such as the following:
   1. Searching 
   2. Sorting 
   3. Insertion 
   4. Deletion 
   5. Manipulation
   
## Collection Hierarchy
     ![Diagram](https://github.com/AnerayeVijay/kotlin-collection/blob/master/collectionHierarchy.png)  

### Array 
An array is a variable which can store multiple values on different-different indexes. Kotlin has an Array class which has set and get functions, size property, and some other useful methods.
```
class Array<T> private constructor(){  
   val size:Int  
   operator fun get(index: Int):T  
   operator fun set(index: Int, value :T): Unit  
   operator fun iterator(): Iterator<T>  
//..  
}   
```
Few examples using array are [here](https://github.com/AnerayeVijay/kotlin-collection/blob/master/src/test/kotlin/com/vijayaneraye/array/ArrayDemoTest.kt)
### Iterable vs MutableIterable Interface
   - Kotlin has two base collection interfaces, namely Iterable and MutableIterable.
      ##### Iterable
         1. All collection interfaces in Kotlin are originated from the Iterable interface.
         2. Iterable interface enables collections to be represented as a sequence of elements and they can be iterate naturally.
          The Iterable interface is extended by the Collection interface, which defines basic read-only collection operations (like

size, isEmpty(), contains(), and so on).

## Developers: Getting Started

```sh
# Install Homebrew (see https://brew.sh).
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

# Install Java 8.
brew tap caskroom/versions
brew cask install java8

# Checkout the monorepo:
git clone https://github.com/AnerayeVijay/kotlin-beginner.git
```
### Running the Applications

- Go inside `kotlin-beginner`
- Open the project in IntelliJ IDEA
  1. Tell it to overwrite `.idea`, then revert all changes IntelliJ made to that directory
  2. You can run the test cases through IntelliJ or
   run ```gradle build``` from terminal or commandprompt 

