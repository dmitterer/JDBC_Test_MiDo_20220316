import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ZugangsdatenRepoImpl implements ZugangsdatenRepository {

    private Connection con;

    public ZugangsdatenRepoImpl() throws SQLException, ClassNotFoundException {
        this.con = MySqLDBVerbindung.getConnection("jdbc:mysql://localhost:3306/zugangsdaten", "root", "");
    }

    @Override
    public Optional<Zugangsdaten> insert(Zugangsdaten entity) {
        return null;
    }


        @Override
        public Optional<Zugangsdaten> getById (Long id){
            return Optional.empty();
        }

    @Override
    public List<Zugangsdaten> getAll() {

        String sql = "Select * from `zuganngsdaten`";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Zugangsdaten> zugangsdatenListe = new ArrayList<>();
            while (resultSet.next()) {
                zugangsdatenListe.add(new Zugangsdaten(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("url")
                ));

            }
            return zugangsdatenListe;
        } catch (SQLException e) {

            throw new DatenbankException("Database error occured!");
        }
    }

        @Override
        public List<Zugangsdaten> getAllWithUrlContaining (String urlpart){
            return null;
        }
    }

