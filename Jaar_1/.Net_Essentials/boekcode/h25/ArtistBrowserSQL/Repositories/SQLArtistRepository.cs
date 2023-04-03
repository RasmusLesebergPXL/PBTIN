using System.Collections.Generic;
using ArtistBrowserSQL.Models;
using ArtistBrowserSQL.Repositories;
using System.Data.SqlClient;
using System;

namespace ArtistBrowserSQL
{
    public class SQLArtistRepository : IArtistRepository, IDisposable
    {
        private const string ConnectionString =
            @"Data source=(localdb)\mssqllocaldb;" +
            @"Initial Catalog=MusicSales;Integrated Security=True";
        private SqlConnection _connection;

        public SQLArtistRepository()
        {
            _connection = new SqlConnection(ConnectionString);
            _connection.Open();
        }

        public void Dispose()
        {
            if (_connection != null)
            {
                _connection.Dispose();
            }
        }

        public IList<Artist> GetAll()
        {
            var artists = new List<Artist>();
            var command = new SqlCommand("SELECT * FROM ARTISTS", _connection);
            SqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                artists.Add(new Artist
                {
                    Id = Convert.ToInt32(reader[0]),
                    Name = Convert.ToString(reader[1]),
                    Company = Convert.ToString(reader[2]),
                    Sales = Convert.ToDouble(reader[3])
                });
            }

            return artists;
        }

        public void Update(Artist artist)
        {
            var command = new SqlCommand()
            {
                Connection = _connection,
                CommandText = "UPDATE ARTISTS SET NAME = @name, " + 
                              "COMPANY = @company, SALES = @sales " +
                              "WHERE ID = @Id"
            };
            command.Parameters.AddWithValue("@Id", artist.Id);
            command.Parameters.AddWithValue("@name", artist.Name);
            command.Parameters.AddWithValue("@company", artist.Company);
            command.Parameters.AddWithValue("@sales", artist.Sales);
            int numberOfRowsAffected = command.ExecuteNonQuery();
        }     
    }
}