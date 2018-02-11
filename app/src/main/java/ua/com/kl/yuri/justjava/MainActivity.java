/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package ua.com.kl.yuri.justjava;
 *
 */
package ua.com.kl.yuri.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    String clientName = "No name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    /**
     * This GetName field input
     */
    private String getName(){
        EditText strName = (EditText) findViewById(R.id.input_name);

        if (strName.getText().length() == 0) {
            clientName = "No name";
        } else {
            Editable getNameClient = strName.getText();
            clientName = (String) getNameClient.toString();
        }

        return clientName;
    }

    /**
     * This CheckBox cream
     */
    boolean hasWhippedCream;
    public boolean buttonChoiceCream(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);

        if(checkBox.isChecked()) {

            hasWhippedCream = true;
//            Log.v("MainActivity", "checkBox status is " + hasWhippedCream);
            return hasWhippedCream;
        } else {

            hasWhippedCream = false;
//            Log.v("MainActivity", "checkBox status is " + hasWhippedCream);
            return hasWhippedCream;
        }
    }

    /**
     * This CheckBox chocolate
     */
    boolean hasChoco;
    public boolean buttonChoiceChoco(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_chocolate);

        if(checkBox.isChecked()) {

            hasChoco = true;
//            Log.v("MainActivity", "checkBox status is " + hasChoco);
            return hasChoco;
        } else {
//            checkBox.setChecked(false);

            hasChoco = false;
//            Log.v("MainActivity", "checkBox status is " + hasChoco);
            return hasChoco;
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param --quantity is the number of cups of coffee ordered
     */

    public void incrementOrder(View view) {
        quantity++;

        display(quantity);
        displayPricePreview(quantity);
    }

    public void decrementOrder(View view) {
        if (quantity == 0) {
            this.quantity = 0;
        } else {
            this.quantity--;
        }

        display(quantity);
        displayPricePreview(quantity);
    }

    /**
     * This method is called when the order button is clicked + or -.
     */
    private void displayPricePreview(int number) {
        TextView priceView = (TextView) findViewById(R.id.price_view);
        priceView.setText("" + (number * 5));
    }


    /**
     * This method is called when the order button is clicked.
     */
    /**
     * variable int for counter method submitOrder
     */

    public void submitOrder(View view) {
        String infoSummary = submitOrderSummary();
        String priceMessage = infoSummary + "Total: $" + (quantity * 5);
        String textMessage = priceMessage + "\n" + "Thank you!" + "\n";

        displayMessage(textMessage);
    }

    /**
     * This method is name and quality
     */
    private String submitOrderSummary() {
        String info = "Name: " + getName() + "\n" + "Added Whipped Cream " + hasWhippedCream + "\n" + "Added Chocolate " + hasChoco + "\n" + "Quantity: " + quantity + "\n";

        return info;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}