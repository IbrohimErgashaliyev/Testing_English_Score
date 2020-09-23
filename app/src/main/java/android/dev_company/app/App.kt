package android.dev_company.app

import android.app.Application
import android.dev_company.data.local.SharedPreference
import android.dev_company.data.local.room.AppDataBase
import android.dev_company.data.local.room.entities.TestData
import android.dev_company.utils.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:57
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreference.init(this)
        instance = this
        val saver = SharedPreference.instance
        if (!saver.isOpenedBefore) {
            saver.isOpenedBefore = true
            loadData()
        }
    }

    companion object {
        lateinit var instance: App
    }

    private fun loadData() {
        val tests = ArrayList<TestData>()
        /**
         * Adding beginners data
         * */
        tests.add(
            TestData(
                0,
                "Where do you live?",
                "I am live in London.",
                "My live is London.",
                "I live in London.",
                "I lives in London.",
                "I live in London.",
                BEGINNER
            )
        )
        tests.add(
            TestData(
                0,
                "Find the correct sentence.",
                "He has two brothers.",
                "I has two brothers.",
                "He got two brothers.",
                "He two brothers.",
                "He has two brothers.",
                BEGINNER
            )
        )
        tests.add(
            TestData(
                0,
                "Find the correct sentence.",
                "They is Italian.",
                "They is Italy.",
                "They are Italian.",
                "They Italian.",
                "They are Italian.",
                BEGINNER
            )
        )
        tests.add(
            TestData(
                0,
                "Find the correct sentence.",
                "My name is Margaret.",
                "My name are Margaret.",
                "Margaret are my name.",
                "Margaret be my name.",
                "My name is Margaret.",
                BEGINNER
            )
        )
        tests.add(
            TestData(
                0,
                "Find the correct sentence.",
                "No. My are American.",
                "No. My is American.",
                "No. I is American.",
                "No. I am American.",
                "No. I am American.",
                BEGINNER
            )
        )
        tests.add(
            TestData(
                0,
                "Find the correct sentence.",
                "Me like coffee.",
                "I like the coffee.",
                "I like coffee.",
                "Me don't like coffee.",
                "I like coffee.",
                BEGINNER
            )
        )

        /**
         * Adding elementarys data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of Elementary",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ELEMENTARY
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ELEMENTARY
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ELEMENTARY
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ELEMENTARY
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ELEMENTARY
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ELEMENTARY
            )
        )

        /**
         * Adding Pre-intermediate data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of Pre-intermediate",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                PRE_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                PRE_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                PRE_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                PRE_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                PRE_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                PRE_INTERMEDIATE
            )
        )

        /**
         * Adding Intermediate data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of Intermediate",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                INTERMEDIATE
            )
        )

        /**
         * Adding Upper-Intermediate data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of Upper-Intermediate",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                UPPER_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                UPPER_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                UPPER_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                UPPER_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                UPPER_INTERMEDIATE
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                UPPER_INTERMEDIATE
            )
        )

        /**
         * Adding Advanced data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of Advanced",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ADVANCED
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ADVANCED
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ADVANCED
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ADVANCED
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ADVANCED
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                ADVANCED
            )
        )

        /**
         * Adding IELTS-Foundation data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of IELTS-Foundation",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_FOUNDATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_FOUNDATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_FOUNDATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_FOUNDATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_FOUNDATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_FOUNDATION
            )
        )

        /**
         * Adding IELTS-Graduation data
         * */
        tests.add(
            TestData(
                0,
                "Question1 of IELTS-Graduation",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_GRADUATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question2",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_GRADUATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question3",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_GRADUATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question4",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_GRADUATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question5",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_GRADUATION
            )
        )
        tests.add(
            TestData(
                0,
                "Question6",
                "variant1",
                "variant2",
                "variant3",
                "varaint4",
                "answer",
                IELTS_GRADUATION
            )
        )
        AppDataBase.getDataBase(this).testDao().addAll(tests)
    }
}