package com.vignesh.harrypotterquiz

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val question1 = Question(1,
            "What is the name of the place you are looking at?",
            R.drawable.ic_hogwarts,
            "University of Coimbra",
            "University of Glasgow",
            "Hogwarts",
            "Ilvermorny",
            2
        )
        val question2 = Question(2,
            "What is the name of the house you are looking at?",
            R.drawable.ic_hufflepuff,
            "Gryffindor",
            "Hufflepuff",
            "Ravenclaw",
            "Slytherin",
            1
        )
        val question3 = Question(3,
            "What is the name of the Character you are looking at?",
            R.drawable.ic_tom_marvolo_riddle,
            "Draco Malfoy",
            "Tom Marvolo Riddle",
            "Lucius Malfoy",
            "Albus Dumbledore",
            1
        )
        val question4 = Question(4,
            "What is the name of the Character you are looking at?",
            R.drawable.ic_dobby,
            "Hokey",
            "Kreacher",
            "Winky",
            "Dobby",
            3
        )
        val question5 = Question(5,
            "What is the name of the symbol you are looking at?",
            R.drawable.ic_deathly_hollows,
            "Invisibility Cloak",
            "Deathly Hallows",
            "Harry’s Lightning Bolt",
            "Platform 9 ¾",
            1
        )
        val question6 = Question(6,
            "What is the name of the Character you are looking at?",
            R.drawable.ic_peter_pettigrew,
            "Peter Pettigrew",
            "Remus Lupin",
            "James Potter",
            "Sirius Black",
            0
        )
        val question7 = Question(7,
            "What are you looking at?",
            R.drawable.ic_horcruxes,
            "Wands",
            "Horcruxes",
            "Potions",
            "Portkeys",
            1
        )
        val question8 = Question(8,
            "What is the name of the Character you are looking at?",
            R.drawable.ic_petunia,
            "Luna Lovegood",
            "Ginevra Weasley",
            "Petunia Dursley",
            "Minerva McGonagall",
            2
        )
        val question9 = Question(9,
            "What is the name of the Character you are looking at?",
            R.drawable.ic_fawkes,
            "Crookshanks",
            "Fawkes",
            "Hedwig",
            "Hippogriffs",
            1
        )
        val question10 = Question(10,
            "What is the name of the movie that has this scene?",
            R.drawable.ic_the_order_of_the_phoenix,
            "Harry Potter and the Philosopher's Stone",
            "Harry Potter and the Chamber of Secrets",
            "Harry Potter and the Half-Blood Prince",
            "Harry Potter and the Order of the Phoenix",
            3
        )
        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)
        questionsList.add(question6)
        questionsList.add(question7)
        questionsList.add(question8)
        questionsList.add(question9)
        questionsList.add(question10)
        return questionsList
    }
}