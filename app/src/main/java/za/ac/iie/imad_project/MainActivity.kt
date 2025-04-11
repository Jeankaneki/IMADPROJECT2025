package za.ac.iie.imad_project


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val inputTime = findViewById<EditText>(R.id.editTextText)
        val suggestBtn = findViewById<Button>(R.id.button)
        val resetBtn = findViewById<Button>(R.id.button2)
        val mealPicture = findViewById<ImageView>(R.id.imageView3)

        suggestBtn.setOnClickListener {
            suggestBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
            suggestBtn.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
            resetBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
            resetBtn.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light))

            val timeOfDay = inputTime.text.toString().trim().lowercase()
            var mealSuggestions: String? = null
            var mealOutput = 0

            //
            if (timeOfDay == "morning" || timeOfDay == "breakfast") {
                mealSuggestions = "Smashed avocados and eggs"
                mealOutput = R.drawable.smashedavocadosandeggs
            } else if (timeOfDay == "mid-morning" || timeOfDay == "mid morning") {
                mealSuggestions = "Oranges, bananas and apples"
                mealOutput = R.drawable.orangesbananasapples
            } else if (timeOfDay == "afternoon" || timeOfDay == "lunch") {
                mealSuggestions = "Wrap chicken and sandwich"
                mealOutput = R.drawable.wrapchickenandsandwich
            } else if (timeOfDay == "mid-afternoon" || timeOfDay == "mid afternoon") {
                mealSuggestions = "pancakes"
                mealOutput = R.drawable.pancakes
            } else if (timeOfDay == "evening" || timeOfDay == "dinner") {
                mealSuggestions = "Chicken noodle soup with rice"
                mealOutput = R.drawable.chickennoodlesoupwithrice
            } else if (timeOfDay == "night" || timeOfDay == "dessert") {
                mealSuggestions = "cookies with milk"
                mealOutput = R.drawable.cookieswithmilk
            }

            val suggestOut = findViewById<TextView>(R.id.textView2)
            if (mealSuggestions != null) {
                suggestOut.text = "Suggested meal: $mealSuggestions"
                suggestOut.setTextColor(ContextCompat.getColor(this, android.R.color.holo_orange_light))
                if (mealOutput != 0) {
                    mealPicture.setImageResource(mealOutput)
                } else {
                    mealPicture.setImageDrawable(null)
                }
            } else {
                suggestOut.text = "Oops! Valid options: morning, mid morning, afternoon, mid afternoon, evening, night"
                suggestOut.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                suggestOut.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
                suggestBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                suggestBtn.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                mealPicture.setImageDrawable(null)


               // suggestionOutput.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
               // suggestionOutput.text = "Oups! Invalid mealtime input. Valid options: morning, mid-morning, afternoon, mid-afternoon, dinner, night "
                //suggestionOutput.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
                //suggestButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                //
            }
        }

        resetBtn.setOnClickListener {
            inputTime.text.clear()
            val suggestionOutput = findViewById<TextView>(R.id.textView2)
            suggestionOutput.text = "Hello again! Please enter a mealtime to get meal suggestions"
            suggestionOutput.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            suggestionOutput.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
            mealPicture.setImageDrawable(null)
            suggestBtn.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_light))
            suggestBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
            resetBtn.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            resetBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))

           //
           //
           // suggestButton.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_light))
           // resetButton.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        }
    }
}



