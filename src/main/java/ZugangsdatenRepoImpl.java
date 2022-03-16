import java.sql.*;
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
        EigeneAsserts.notNull(entity);
       try {
           String sql = "INSERT INTO `zugangsdaten` (`id`, `username`, `password`, `url`) VALUES (NULL, ?, ?, ?)";
           PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           preparedStatement.setString(1, entity.getUsername());
           preparedStatement.setString(2, entity.getPasswort());
           preparedStatement.setString(3, entity.getUrl());

           int affectedRows = preparedStatement.executeUpdate();

           if (affectedRows == 0)
           {
               return Optional.empty();

           } else
           {
               ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

               if (generatedKeys.next())
               {
                   return this.getById(generatedKeys.getLong(1));

               }else
               {
                   return Optional.empty();

               }
           }
       }catch (SQLException sqlException)
       {

           throw new DatenbankException(sqlException.getMessage());
       }
       }


    @Override
    public Optional<Zugangsdaten> getById(Long id) {
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
    } catch(SQLException e)

    {

        throw new DatenbankException("Database error occured!");
    }

    }


        @Override
        public List<Zugangsdaten> getAllWithUrlContaining (String urlpart){
            return null;
        }
    }

