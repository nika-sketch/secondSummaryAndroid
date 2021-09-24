package ge.nlatsabidze.secondsummaryandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ge.nlatsabidze.secondsummaryandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val informationCollection = mutableListOf<String>()

        val temporaryCollectionforAdding = mutableListOf<String>()

        val temporaryCollectionforRemoving = mutableListOf<String>()

        val temporaryCollectionforUpdating = mutableListOf<String>()

        var informationAdded = 0
        var informationRemoved = 0

        val resultTextView = binding.textView


        val addUser = binding.addBtn
        val removeUser = binding.removeBtn
        val updateUser = binding.updateBtn

        val firstNameInput = binding.firstNameId
        val lastNameInput = binding.lastNameId
        val ageInput = binding.ageId
        val emailInput = binding.emailId

        val firstName = firstNameInput.text.toString()
        val lastName = lastNameInput.text.toString()
        val age = ageInput.text.toString()
        val email = emailInput.text.toString()

        addUser.setOnClickListener {

            temporaryCollectionforAdding.add(firstName)
            temporaryCollectionforAdding.add(lastName)
            temporaryCollectionforAdding.add(age)
            temporaryCollectionforAdding.add(email)

            if (firstNameInput.text.length != 0 && lastNameInput.text.length != 0 && ageInput.text.length != 0 &&
                emailInput.text.length != 0 && !informationCollection.containsAll(temporaryCollectionforAdding)) {

                informationCollection.addAll(temporaryCollectionforAdding)
                informationAdded++

                resultTextView.text = "User added successfully"
                resultTextView.setTextColor(Color.GREEN)

                temporaryCollectionforAdding.clear()
                firstNameInput.text.clear()
                lastNameInput.text.clear()
                ageInput.text.clear()
                emailInput.text.clear()

            } else {

                resultTextView.text = "User Already Exists"
                resultTextView.setTextColor(Color.RED)
            }
        }

        removeUser.setOnClickListener {
            temporaryCollectionforRemoving.add(firstName)
            temporaryCollectionforRemoving.add(lastName)
            temporaryCollectionforRemoving.add(age)
            temporaryCollectionforRemoving.add(email)

            if (firstNameInput.text.length != 0 && lastNameInput.text.length != 0 && ageInput.text.length != 0 &&
                emailInput.text.length != 0 && informationCollection.containsAll(temporaryCollectionforRemoving)) {
                informationCollection.removeAll(temporaryCollectionforRemoving)
                informationRemoved++

                resultTextView.text = "User deleted successfully"
                resultTextView.setTextColor(Color.GREEN)

                temporaryCollectionforRemoving.clear()
                firstNameInput.text.clear()
                lastNameInput.text.clear()
                ageInput.text.clear()
                emailInput.text.clear()

            } else {

                resultTextView.text = "User doesn't exists"
                resultTextView.setTextColor(Color.RED)
            }
        }

        updateUser.setOnClickListener {
            temporaryCollectionforUpdating.add(firstName)
            temporaryCollectionforUpdating.add(lastName)
            temporaryCollectionforUpdating.add(age)
            temporaryCollectionforUpdating.add(email)

            if (firstNameInput.text.length != 0 && lastNameInput.text.length != 0 && ageInput.text.length != 0 &&
                emailInput.text.length != 0 && !informationCollection.containsAll(temporaryCollectionforUpdating)) {

                informationCollection[0] = firstName
                informationCollection[1] = lastName
                informationCollection[2] = age
                informationCollection[3] = email

                temporaryCollectionforUpdating.clear()
                firstNameInput.text.clear()
                lastNameInput.text.clear()
                ageInput.text.clear()
                emailInput.text.clear()

                resultTextView.text = "User updated"
                resultTextView.setTextColor(Color.GREEN)
            } else {
                resultTextView.text = "User is not updated"
                resultTextView.setTextColor(Color.RED)
            }
        }
    }
}