package pageRepository;

import E2ESampleProject.BaseProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CasualDressPage extends BaseProperties {

    @FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li//*[@type='checkbox']")
    List<WebElement> sizeCheckBox;

    @FindBy(xpath = "//*[@class='product-container']")
    List<WebElement> dressList;

    @FindBy(xpath = "//*[@class='button ajax_add_to_cart_button btn btn-default']")
    List<WebElement> addToCart;

    @FindBy(xpath = "//*[@class='clearfix']//*[@class='layer_cart_product col-xs-12 col-md-6']//h2")
    WebElement message;

    @FindBy(xpath = "//*[@class='clearfix']//*[@class='ajax_block_products_total']")
    WebElement totalProducts;

    @FindBy(xpath = "//*[@class='clearfix']//*[@class='ajax_cart_shipping_cost']")
    WebElement totalShipping;

    @FindBy(xpath = "//*[@class='clearfix']//*[@class='ajax_block_cart_total']")
    WebElement totalCost;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    WebElement checkoutbtn;


public CasualDressPage() {
        PageFactory.initElements(driver, this);
    }

    public String getCasualPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> selectSize() {
        return sizeCheckBox;
    }

    public List<WebElement> getDressList() {
        return dressList;
    }

    public List<WebElement> addToCartbtn() {
        return addToCart;
    }

    public float totalProductCost() {

        String product= totalProducts.getText().substring(1);
        float productCost = Float.parseFloat(product);
        return productCost;
    }

    public float totalShippingCost() {

        String a = totalShipping.getText().substring(1);
        float shippingCost = Float.parseFloat(a);
        System.out.println(shippingCost);
        return shippingCost;
    }

    public float totalCalcCost() {
        String b= totalCost.getText().substring(1);
        float total = Float.parseFloat(b);
        System.out.println(total);
        return total;
    }

    public String cartMessage() {
        return message.getText();
    }

    public WebElement checkoutbtn()
    {
        return checkoutbtn;
    }

}
