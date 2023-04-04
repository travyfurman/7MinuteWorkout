package com.example.a7minuteworkout

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

        val abdominalCrunch = ExerciseModel(
            2,
            "Abdominal Crunch",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        )
        exerciseList.add(abdominalCrunch)

        val pushup = ExerciseModel(
            3,
            "Pushup",
            R.drawable.ic_pushup,
            false,
            false
        )
        exerciseList.add(pushup)

        val highKneesRunningInPlace = ExerciseModel(
            4,
            "High Knees Running in Place",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false
        )
        exerciseList.add(highKneesRunningInPlace)

        val lunge = ExerciseModel(
            5,
            "Lunge",
            R.drawable.ic_lunge,
            false,
            false
        )
        exerciseList.add(lunge)

        val plank = ExerciseModel(
            6,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        )
        exerciseList.add(plank)

        val pushupWIthRotation = ExerciseModel(
            7,
            "Pushup with Rotation",
            R.drawable.ic_pushup_with_rotation,
            false,
            false
        )
        exerciseList.add(pushupWIthRotation)

        val squat = ExerciseModel(
            8,
            "Squat",
            R.drawable.ic_squat,
            false,
            false
        )
        exerciseList.add(squat)

        val sidePlank = ExerciseModel(
            9,
            "Side Plank",
            R.drawable.ic_side_plank,
            false,
            false
        )
        exerciseList.add(sidePlank)

        val stepOntoChair = ExerciseModel(
            10,
            "Step onto Chair",
            R.drawable.ic_step_onto_chair,
            false,
            false
        )
        exerciseList.add(stepOntoChair)

        val tricepDipWithChair = ExerciseModel(
            11,
            "Tricep Dip with Chair",
            R.drawable.ic_tricep_dip_with_chair,
            false,
            false
        )
        exerciseList.add(tricepDipWithChair)

        val wallSit = ExerciseModel(
            12,
            "Wall Sit",
            R.drawable.ic_wallsit,
            false,
            false
        )
        exerciseList.add(wallSit)


        return exerciseList
    }
}