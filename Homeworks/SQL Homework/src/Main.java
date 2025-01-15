import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLHomeWork {

    public static void main(String[] args) {
        try {

            Document doc = Jsoup.connect("https://allo.ua/ua/catalogsearch/result/?q=iphone").get();
            Elements products = doc.select(".product-item-info");


            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourDatabaseName", "username", "password");

            int count = 0;
            for (Element product : products) {
                if (count >= 3) break;

                String phoneName = product.select(".product-name a").text();
                String goodsId = product.attr("data-product-id"); // Предполагаем, что ID продукта находится в атрибуте


                if (!isPhonePresent(connection, phoneName, goodsId)) {
                    connection;(connection, phoneName, goodsId);
                }

                count++;
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean isPhonePresent(Connection connection, String phoneName, String goodsId) throws Exception {
        String query = "SELECT * FROM Phones WHERE PhoneName = ? AND GoodsId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, phoneName);
        preparedStatement.setString(2, goodsId);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }


    private static void insertPhone(Connection connection, String phoneName, String goodsId) throws Exception {
        String insertQuery = "INSERT INTO Phones (PhoneName, GoodsId) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, phoneName);
        preparedStatement.setString(2, goodsId);
        preparedStatement.executeUpdate();

        System.out.println("Inserted: " + phoneName + " with GoodsId: " + goodsId);
    }
}

}