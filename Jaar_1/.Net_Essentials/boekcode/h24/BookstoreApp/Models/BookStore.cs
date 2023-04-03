using System;
using System.Collections.Generic;

namespace BookstoreApp.Models
{
    public class BookStore
    {
        private IList<Book> _books;
  
        public BookStore()
        {
            _books = new List<Book>()
            {
                new Book()
                {
                    ISBN = 9789043032421,
                    Title = "Programmeren in C#, 2e editie met MyLab NL",
                    ShortDescription = "Programmeren in C# (C Sharp) is geschreven in een eenvoudige, directe en heldere stijl. Het begint met een uitleg over hoe objecten gebruikt worden en gaat in op variabelen, toekenningsopdrachten en methoden. Vervolgens wordt het gebruik van objecten uit bibliotheekklassen geïntroduceerd. En daarna een uileg hoe instructies geschreven worden voor selectie en herhaling. Ten slotte leren studenten hoe zij zelf klassen kunnen schrijven.",
                    MainAuthor = new Author ()
                    {
                        Id = 1,
                        FirstName = "Doug",
                        LastName = "Bell"
                    },
                    PageCount = 540,
                    PublicationDate = new DateTime(2015, 1, 7),
                    Price = 44.95
                },
                new Book()
                {
                    ISBN = 9789043034999,
                    Title = "Programmeren in Java met BlueJ, 6e editie met MyLab NL",
                    ShortDescription = "Programmeren in Java met BlueJ is een helder geschreven en compact boek ter inleiding tot objectgeoriënteerd programmeren in Java met behulp van BlueJ, een omgeving die speciaal is ontwikkeld voor het leren programmeren in Java. Het boek is een makkelijk te volgen en uitgebreid naslagwerk dat studenten op een duidelijke manier met Java laat kennismaken en leert Java te doorgronden. Door het oefenmateriaal kunnen studenten deze opgedane kennis meteen in de praktijk uitvoeren.",
                    MainAuthor = new Author ()
                    {
                        Id = 2,
                        FirstName = "David",
                        LastName = "Barnes"
                    },
                    PageCount = 664,
                    PublicationDate = new DateTime(2017, 3, 15),
                    Price = 59.95
                },
                new Book()
                {
                    ISBN = 9789043033916,
                    Title = "Ethiek in sociaal werk, 3e editie met MyLab NL",
                    ShortDescription = "Maatschappelijk werkers, sociaal pedagogisch hulpverleners, pedagogen en cultureel werkers verlenen hulp en diensten aan mensen die kwetsbaar zijn. Hierbij spelen normen en waarden een grote rol. Ethiek in sociaal werk behandelt de belangrijkste ethische begrippen en legt de relatie met de verschillende beroepscodes op dit gebied.",
                    MainAuthor = new Author ()
                    {
                        Id = 3,
                        FirstName = "Jacquelien",
                        LastName = "Rothfusz"
                    },
                    PageCount = 328,
                    PublicationDate = new DateTime(2017, 3, 23),
                    Price = 39.95
                },
                new Book()
                {
                    ISBN = 9789043018791,
                    Title = "Programmeren in Java met Greenfoot",
                    ShortDescription = "In Programmeren met Java in Greenfoot leer je hoe je grafische computerprogramma’s programmeert met behulp van de programmeertaal Java en de ontwikkelomgeving Greenfoot.",
                    MainAuthor = new Author ()
                    {
                        Id = 4,
                        FirstName = "Michael",
                        LastName = "Kölling"
                    },
                    PageCount = 232,
                    PublicationDate = new DateTime(2011, 1, 13),
                    Price = 45.95
                },
                new Book()
                {
                    ISBN = 9789043033343,
                    Title = "Kwaliteitsmanagement, 3e editie met MyLab NL",
                    ShortDescription = "Organisaties onderscheiden zich door de kwaliteit van hun producten of diensten, goede arbeidsomstandigheden en hun houding ten aanzien van duurzaamheid. In dit zeer systematische en toegankelijk geschreven boek bespreekt de auteur de verschillende vormen van kwaliteitsmanagement en de modellen en systemen die hierbij worden gebruikt, waaronder het INK-managementmodel, Six Sigma en Lean. Daarnaast legt hij aan de hand van sprekende voorbeelden een verbinding met de dagelijkse praktijk.",
                    MainAuthor = new Author ()
                    {
                        Id = 5,
                        FirstName = "Ron",
                        LastName = "Emmerik"
                    },
                    PageCount = 320,
                    PublicationDate = new DateTime(2016, 6, 15),
                    Price = 46.95
                },
                new Book()
                {
                    ISBN = 9789043035804,
                    Title = "Principes van databases, 2e editie met MyLab NL",
                    ShortDescription = "Principes van databases geeft inzicht in het uitgebreide domein van databasesystemen. Daarbij besteedt de auteur bijzondere aandacht aan relationele databases en hun objectgeoriënteerde faciliteiten en wordt kort ingegaan op diverse aspecten van andere databasemodellen en NoSQL-oplossingen voor het beheer van ‘big’ data.",
                    MainAuthor = new Author ()
                    {
                        Id = 6,
                        FirstName = "Guy",
                        LastName = "De Tré"
                    },
                    PageCount = 440,
                    PublicationDate = new DateTime(2017, 7, 11),
                    Price = 51.95
                },
                new Book()
                {
                    ISBN = 9789043035897,
                    Title = "Professioneel communiceren in de zorg (EC-versie)",
                    ShortDescription = "In Professioneel communiceren in de zorg staat de verpleegkundige als communicerende collega centraal. Professionals met verschillende achtergronden en startniveaus moeten met elkaar samenwerken om een goed team te kunnen vormen en dat lukt alleen wanneer zij effectief communiceren.",
                    MainAuthor = new Author ()
                    {
                        Id = 7,
                        FirstName = "Titia",
                        LastName = "Struiving"
                    },
                    PageCount = 208,
                    PublicationDate = new DateTime(2017, 6, 1),
                    Price = 34.95
                }
            };
        }

        public IList<Book> GetAllBooks()
        {
            return _books;
        }
    }
}
