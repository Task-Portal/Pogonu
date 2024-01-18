package com.example.pogonu

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    val inputString =
        "cap,genera_mayour,polkov,sernour,efr,let,prapor,sern_prapor,general_army,marshal_rus_fed,rad,sern_serg,general_let,mayour,serg,young_let,general_polkov,pod_polk,sern_let,young_serg"

    private val epauletSign: ArrayList<String> = ArrayList(inputString.split(","))

    fun getQuestions(): ArrayList<Question> {


        val questionsList = ArrayList<Question>()
        epauletSign.shuffle()
        for ((index, countryCode) in epauletSign.withIndex()) {
            val fourCountries = getFourEpaulets(countryCode)
            val flagCountryName = getEpauletName(countryCode)
            val question = Question(
                index + 1,
                "Чей пагон?",
                R.drawable::class.java.getDeclaredField(countryCode).getInt(null),
                fourCountries[0],
                fourCountries[1],
                fourCountries[2],
                fourCountries[3],
                fourCountries.indexOf(flagCountryName) + 1
            )
            questionsList.add(question)
        }

        return questionsList
    }

    private fun getEpauletName(sign: String): String {
        return when (sign) {
            "cap" -> "Капитан"
            "genera_mayour" -> "Генерал майор"
            "polkov" -> "Полковник"
            "sernour" -> "Старшина"
            "efr" -> "Евфрейтор"
            "let" -> "Лейтинант"
            "prapor" -> "Прапорщик"
            "sern_prapor" -> "Старший прапорщик"
            "general_army" -> "Генерал"
            "marshal_rus_fed" -> "Маршал русской армии"
            "rad" -> "Рядовой"
            "sern_serg" -> "Старший сержант"
            "general_let" -> "Генерал лейтенант"
            "mayour" -> "Майор"
            "serg" -> "Сержант"
            "young_let" -> "Младший лейтенант"
            "general_polkov" -> "Генерал полковник"
            "pod_polk" -> "Подполковник"
            "sern_let" -> "Старший лейтенант"
            "young_serg" -> "Младший сержант"
            else -> "Неизвесный пагон"
        }
    }

    private fun getFourEpaulets(code: String): ArrayList<String> {
        val epaulets = ArrayList<String>()
        epaulets.add(getEpauletName(code))


        while (epaulets.size != 4) {
            val randomNum = (0 until epauletSign.size).random()
            val randomEpauletCode = epauletSign[randomNum]
            val randomEpauletName = getEpauletName(randomEpauletCode)
            if (!epaulets.contains(randomEpauletName)) {
                epaulets.add(randomEpauletName)
            }
        }
        epaulets.shuffle()
        return epaulets

    }

}