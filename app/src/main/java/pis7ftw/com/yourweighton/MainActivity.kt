package pis7ftw.com.yourweighton

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {

    val MERCURY_CONSTANT: Float = 0.378F
    val VENUS_CONSTANT: Float = 0.907F
    val MARS_CONSTANT: Float = 0.377F
    val JUPITER_CONSTANT: Float = 2.36F
    val SATURN_CONSTANT: Float = 0.916F
    val URANUS_CONSTANT: Float = 0.889F
    val NEPTUNE_CONSTANT: Float = 1.12F
    val PLUTO_CONSTANT: Float = 0.071F


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * roundDecimal
     * returns Double
     * Formats the input Double to 2 places.
     */
    fun roundDecimal(decimal: Double): Double {
        return String.format("%.2f", decimal).toDouble()
    }

    /**
     * weightOnPlanet
     * returns void
     * Displays the message containing the users weight on the speficied planet
     * in the txtPlanetWeight editview.
     */
    fun weightOnPlanet(weight: Double, planet: String) {

        txtPlanetWeight.text  = "Your weight on: $planet is " + roundDecimal(weight) + " pounds!"
    }

    /**
     * onCheckBoxClicked
     * return void
     * Listens to the checkbox clicked event and displays
     * the entered weight for the designated planet, then clears the
     * checkbox.
     * If checkbox is empty, prompt user for Earth weight
     */
    fun onCheckBoxClicked(view: View) {

        view as CheckBox
        if (!txtEDTWeight.text.isEmpty()) {
            var weight = txtEDTWeight.text.toString().toDouble()
            var chkBoxText = view.text.toString()

            when (view.id) {
                R.id.chkMecury -> weightOnPlanet(weight * MERCURY_CONSTANT, chkBoxText)
                R.id.chkVenus -> weightOnPlanet(weight * VENUS_CONSTANT, chkBoxText)
                R.id.chkMars -> weightOnPlanet(weight * MARS_CONSTANT, chkBoxText)
                R.id.chkJupiter -> weightOnPlanet(weight * JUPITER_CONSTANT, chkBoxText)
                R.id.chkSaturn -> weightOnPlanet(weight * SATURN_CONSTANT, chkBoxText)
                R.id.chkUranus -> weightOnPlanet(weight * URANUS_CONSTANT, chkBoxText)
                R.id.chkNeptune -> weightOnPlanet(weight * NEPTUNE_CONSTANT, chkBoxText)
                R.id.chkPluto -> weightOnPlanet(weight * PLUTO_CONSTANT, chkBoxText)

            }
            uncheckCheckBoxes()
        } else {
            txtEDTWeight.setHint("Enter your Earth weight first!")
            txtPlanetWeight.setHintTextColor(Color.RED)
        }
    }

    /**
     * uncheckCheckBoxes
     * return void
     * Loops through all child views in the ConstraintLayout
     * If view is a checkbox...uncheck it.
     */
    fun uncheckCheckBoxes() {

        //Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show()
        var view: View
        val layoutMyLayout = findViewById(R.id.layoutV) as ConstraintLayout
        for (i in 0..layoutV.childCount) {
            if (layoutV.getChildAt(i) != null) { // getChildAt(i) cannot be null.
                view = layoutV.getChildAt(i)
                if (view is CheckBox && view.isChecked) {
                    //Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show()
                    view.isChecked = false
                }
            }
        }
    }
}



