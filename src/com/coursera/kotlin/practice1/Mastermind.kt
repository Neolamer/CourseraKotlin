package com.coursera.kotlin.practice1

fun main() {

    var activate = true

    println("\t-= Mastermind Game =-\n")

    while (activate){
        print("Guess a number/word/combination: ")
        val answer = readLine().toString() //ввод ответа
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\t Start!\n")
        if(!masterMind(answer)){
            activate = false
        }
    }
}

fun masterMind(word: String): Boolean{
    var arr: CharArray = word.toCharArray()
    var isFalse = true //проверка размерности
    var attempt = 1        //номер попытки
    var rightPlaceLetter = 0
    var wrongPlaceLetter = 0
    var result = false
    var question: String
    var yourWord: String
    //var repeatNum: Int

    while(isFalse){
        println("Attempt: $attempt")
        println("______________________________________")
        println(" NOTE. The maximum number of letters must \n "+
                " correspond to the size of the answer. \n" +
                " At the moment it is ${word.length} \n" +
                "______________________________________")
        print("Enter your answer: ")

        yourWord = readLine().toString() // ввод вашего слова
        val arr1: CharArray = yourWord.toCharArray()

        if(word.length < yourWord.length){ // проверка размера ответа
            println("ERROR CODE")
            break
        }

        for (i in arr.indices) {
            if (arr[i] == arr1[i]) {
                ++rightPlaceLetter
            } else if (arr[i] in arr1) {
                ++wrongPlaceLetter
            }
        }


        println("______________________________________")
        print("\n")
            println(" Correct letters, in the correct place: $rightPlaceLetter")
            println(" Correct letters, in the wrong place: $wrongPlaceLetter")
            if(rightPlaceLetter == yourWord.length){
                println("\n Well done! You guessed it! ")
                println(" Do you want to start over? [1/0]")
                question = readLine().toString()
                result = question == "1"
                break
            }
        attempt++
        rightPlaceLetter = 0
        wrongPlaceLetter = 0
    }
    return result
}
