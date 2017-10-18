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
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.R.attr.name;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    //fields
    int quantity = 0;
    String clientName = "Vasya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the price of the order.
     *
     * @param --quantity is the number of cups of coffee ordered
     */

    public void incrementOrder(View view) {
        quantity++;
        display(quantity);
    }
    public void decrementOrder(View view) {
        if(quantity == 0) {
            this.quantity = 0;
        } else {
            this.quantity--;
        }

        display(quantity);
    }


    /**
     * This method is called when the order button is clicked.
     */
    /** variable int for counter method submitOrder*/

    public void submitOrder(View view) {
        //fields local
        String infoSummary = submitOrderSummary();
        String priceMessage = infoSummary + "Total: $" + (quantity * 5);
        String textMessage = priceMessage + "\n" + "Thank you!" + "\n";

        displayMessage(textMessage);
    }

    /** This method is name and quality
     *
     */
    private String submitOrderSummary() {
        String info = "Name: " + clientName + "\n" + "Quantity: " + quantity + "\n";

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