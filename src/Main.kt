/**
 * ===============================================================
 * Kotlin GUI Pop-Up Dialog Demo
 * ===============================================================
 *
 * This is a demo of how to create and manage a pop-up dialog
 * window as part of your application.
 *
 * The pop-up is modal - this means that it retains focus, and the
 * main window can't be interacted with until the pop-up is closed.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model
}


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    // Data fields

    // Functions to update the above data
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var messageLabel: JLabel
    private lateinit var openButton: JButton

    // Dialogs
    private lateinit var examplePopUp: PopUpDialog


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the view with the model data
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Pop-Up Demo"
        contentPane.preferredSize = Dimension(400, 175)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        // Create the pop-up, passing on the app object and a link
        // back to this main window
        examplePopUp = PopUpDialog()

        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 24)

        messageLabel = JLabel("Click the button!")
        messageLabel.horizontalAlignment = SwingConstants.CENTER
        messageLabel.bounds = Rectangle(25, 25, 350, 50)
        messageLabel.font = baseFont
        add(messageLabel)

        openButton = JButton("Open The Pop-Up")
        openButton.bounds = Rectangle(25, 100, 350, 50)
        openButton.font = baseFont
        openButton.addActionListener(this)     // Handle any clicks
        add(openButton)
    }


    /**
     * Update the UI controls based on the current state of the application model
     */
    fun updateView() {
        // View update code here
    }

    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            openButton -> {
                examplePopUp.isVisible = true   // And show it
            }
        }
    }
}


/**
 * Displays a modal dialog
 */
class PopUpDialog(): JDialog() {
    /**
     * Configure the UI
     */
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "Example Pop-Up"
        contentPane.preferredSize = Dimension(400, 200)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("<html>This is an example pop-up dialog window. Like any window it can have controls, respond to events, etc. <br><br>It is a <em>modal</em> window, so it grabs the focus, and the main window can't be interacted with until this pop-up is closed.")
        message.bounds = Rectangle(25, 25, 350, 150)
        message.verticalAlignment = SwingConstants.TOP
        message.font = baseFont
        add(message)
    }

}