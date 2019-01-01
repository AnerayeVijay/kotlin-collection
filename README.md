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
   An array is a variable which can store multiple values on different-different indexes. Kotlin has an Array class which has set and get 
   functions, size property, and some other useful methods.
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
   
      #### Iterable
        1. All collection interfaces in Kotlin are originated from the Iterable interface.
        2. Iterable interface enables collections to be represented as a sequence of elements and they can be iterate naturally.
        3. The Iterable interface is extended by the Collection interface, which defines basic read-only collection operations 
         (likesize,isEmpty(), contains(), and so on)
         
        ##### Collection
        1. The Collection interface extends Iterable and defines methods for determining the presence of elements in the collection, as
        well as the collection size and the check for the zero size container
        ```
           public interface Collection<out E> : Iterable<E> {
             public val size: Int
             public fun isEmpty(): Boolean
    
             public operator fun contains(element: @UnsafeVariance E):  Boolean
             override fun iterator(): Iterator<E>
             public fun containsAll(elements: Collection<@UnsafeVariance E>):Boolean 
            }
        ```
        ###### List
        - From the Collection class derives probably the most used type, List. List is one of the most commonly used collection data
        types
        - A list is an ordered collection of elements. Methods in this interface support read-only access to the collection 
            1. fun get(index: Int):E: This method is used to get an element from the list at the given index.
            2. fun indexOf(element: @UnsafeVariance E):Int: This method is used to identify the index of an element in the list
            3. fun subList(fromIndex: Int, toIndex: Int): List<E>: Returns a portion of the list with the specified fromIndex and toIndex
             value.
            4. Per the Kotlin docs, the difference between listOf and listOfNotNull:
               - listOf: Returns an immutable list containing only the specified object element.
               - listOfNotNull: Returns a new read-only list either of single given element, if it is not null, or empty list if the 
                  element is null.
        - Example of creating list is [here](https://github.com/AnerayeVijay/kotlin-collection/blob/master/src/test/kotlin/com/vijayaneraye/list/CreateListDemoTest.kt)
        - Example of filtering list is [here](https://github.com/AnerayeVijay/kotlin-collection/blob/master/src/test/kotlin/com/vijayaneraye/list/FilterListTest.kt)
        - Example of list map and filter map are [here](https://github.com/AnerayeVijay/kotlin-collection/blob/master/src/test/kotlin/com/vijayaneraye/list/ListMapAndFilterMap.kt)
         
      #### MutableInterable
        1. An iterator over a mutable collection. Provides the ability to remove elements while iterating.
        2. The MutableCollection interface extends the Collection interface and the MutableIterable interface, adding the read-write
         feature.

        ##### MutableIterable
        1. Sibling of Collection iterface is the MutableIterable interface. All this does is redefine the parent iterator() method to
        return a mutable iterator rather than an immutable one:
        ```
         public interface MutableIterable<out T> : Iterable<T> {
            override fun iterator(): MutableIterator<T>
         }

        ```

------------------------


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

