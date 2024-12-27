package gm.model;

import gm.conexion.Conexion;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    public static void createTables() {
        Connection connection = Conexion.getConexion();

        String Address = "CREATE TABLE IF NOT EXISTS Address ("
                + "idAdress INT NOT NULL AUTO_INCREMENT, "
                + "id VARCHAR(45) NOT NULL, "
                + "number VARCHAR(10) NOT NULL, "
                + "floor VARCHAR(10), "
                + "door VARCHAR(10), "
                + "city VARCHAR(45) NOT NULL, "
                + "postal_code VARCHAR(10) NOT NULL, "
                + "country VARCHAR(45) NOT NULL, "
                + "PRIMARY KEY (idAdress)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        String Supplier = "CREATE TABLE IF NOT EXISTS Supplier ("
                + "NIF VARCHAR(9) NOT NULL, "
                + "name VARCHAR(45) NOT NULL, "
                + "phone VARCHAR(20) NOT NULL, "
                + "fax VARCHAR(20), "
                + "address INT NOT NULL, "
                + "PRIMARY KEY (NIF), "
                + "UNIQUE KEY NIF_UNIQUE (NIF), "
                + "FOREIGN KEY (address) REFERENCES Address(idAdress) ON DELETE CASCADE ON UPDATE CASCADE"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        String Brand = "CREATE TABLE IF NOT EXISTS Brand ("
                + "Id INT NOT NULL AUTO_INCREMENT, "
                + "name VARCHAR(45) NOT NULL, "
                + "supplier_nif VARCHAR(9) NOT NULL, "
                + "PRIMARY KEY (Id), "
                + "FOREIGN KEY (supplier_nif) REFERENCES Supplier(NIF) ON DELETE CASCADE ON UPDATE CASCADE"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        String Glasses = "CREATE TABLE IF NOT EXISTS Glasses ("
                + "id INT NOT NULL AUTO_INCREMENT, "
                + "brand_id INT NOT NULL, "
                + "graduation_left DECIMAL(4,2) NOT NULL, "
                + "graduation_right DECIMAL(4,2) NOT NULL, "
                + "frame_type VARCHAR(45) NOT NULL, "
                + "frame_color VARCHAR(45) NOT NULL, "
                + "color_left VARCHAR(45) NOT NULL, "
                + "color_right VARCHAR(45) NOT NULL, "
                + "price DOUBLE NOT NULL, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY (brand_id) REFERENCES Brand(Id) ON DELETE CASCADE ON UPDATE CASCADE"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        String Client = "CREATE TABLE IF NOT EXISTS Client ("
                + "id INT NOT NULL AUTO_INCREMENT, "
                + "name VARCHAR(45) NOT NULL, "
                + "phone VARCHAR(15) NOT NULL, "
                + "mail VARCHAR(45) NOT NULL, "
                + "registration_date DATETIME NOT NULL, "
                + "recommended INT, "
                + "address INT NOT NULL, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY (address) REFERENCES Address(idAdress) ON DELETE CASCADE ON UPDATE CASCADE"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        String Employee = "CREATE TABLE IF NOT EXISTS Employee ("
                + "id INT NOT NULL, "
                + "name VARCHAR(45) DEFAULT NULL, "
                + "PRIMARY KEY (id)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        String Bill = "CREATE TABLE IF NOT EXISTS Bill ("
                + "id INT NOT NULL AUTO_INCREMENT, "
                + "glasses_id INT NOT NULL, "
                + "client_id INT NOT NULL, "
                + "employee_id INT NOT NULL, "
                + "bill_date DATE NOT NULL, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY (glasses_id) REFERENCES Glasses(id) ON DELETE CASCADE ON UPDATE CASCADE, "
                + "FOREIGN KEY (client_id) REFERENCES Client(id) ON DELETE CASCADE ON UPDATE CASCADE, "
                + "FOREIGN KEY (employee_id) REFERENCES Employee(id) ON DELETE CASCADE ON UPDATE CASCADE"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate(Address);
            statement.executeUpdate(Supplier);
            statement.executeUpdate(Brand);
            statement.executeUpdate(Glasses);
            statement.executeUpdate(Client);
            statement.executeUpdate(Employee);
            statement.executeUpdate(Bill);

            System.out.println("Tablas creadas con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}
