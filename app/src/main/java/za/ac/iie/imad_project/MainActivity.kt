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

        // Initialize UI elements by finding their views from the layout
        val inputTime = findViewById<EditText>(R.id.editTextText)
        val suggestBtn = findViewById<Button>(R.id.button)
        val resetBtn = findViewById<Button>(R.id.button2)
        val mealPicture = findViewById<ImageView>(R.id.imageView3)

        // Set click listener for the suggestion button
        suggestBtn.setOnClickListener {
            // Update button colors when pressed
            suggestBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
            suggestBtn.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
            resetBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
            resetBtn.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light))

            // Get and process user input (trim whitespace and convert to lowercase)
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            var mealSuggestions: String? = null
            var mealOutput = 0  // Will hold resource ID for meal image

            // Determine meal suggestion based on time of day input
            if (timeOfDay == "morning" || timeOfDay == "breakfast") {
                mealSuggestions = "Smashed avocados with eggs"
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


            // Update the suggestion text view with results
            val suggestOut = findViewById<TextView>(R.id.textView2)
            if (mealSuggestions != null) {
                // Valid input case
                suggestOut.text = "Suggested meal of the day, try! some $mealSuggestions"
                suggestOut.setTextColor(ContextCompat.getColor(this, android.R.color.holo_orange_light))
                suggestOut.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

                // Set meal image if available
                if (mealOutput != 0) {
                    mealPicture.setImageResource(mealOutput)
                } else {
                    mealPicture.setImageDrawable(null)
                }
            } else {
                // Invalid input case
                suggestOut.text = "Oops! try these valid options: morning, mid morning, afternoon, mid afternoon, evening, night"
                suggestOut.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                suggestOut.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))

                // Update button appearance for error state
                suggestBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                suggestBtn.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                mealPicture.setImageDrawable(null)
            }
        }

        // Set click listener for the reset button
        resetBtn.setOnClickListener {
            // Clear input field
            inputTime.text.clear()

            // Reset suggestion text view to initial state
            val suggestionOutput = findViewById<TextView>(R.id.textView2)
            suggestionOutput.text = "Hello again! Please enter a time of day to get a meal suggestion"
            suggestionOutput.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            suggestionOutput.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

            // Clear meal image
            mealPicture.setImageDrawable(null)

            // Reset button colors to default
            suggestBtn.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_light))
            suggestBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
            resetBtn.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            resetBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark))
        }
    }
}



