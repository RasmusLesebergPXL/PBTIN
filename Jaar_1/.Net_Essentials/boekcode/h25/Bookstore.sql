/* Check if database already exists and delete it if it does exist*/
IF EXISTS(SELECT 1 FROM master.dbo.sysdatabases WHERE name = 'Bookstore') 
BEGIN
DROP DATABASE Bookstore
END
GO

CREATE DATABASE Bookstore
GO

USE [Bookstore]
GO

SET DATEFORMAT ymd
GO

/****** Object:  Table [dbo].[Authors]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Authors] (
    [Id] [int] NOT NULL IDENTITY,
    [FirstName] [nvarchar](max),
    [LastName] [nvarchar](max),
    CONSTRAINT [PK_dbo.Authors] PRIMARY KEY ([Id])
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Books]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books] (
    [ISBN] [bigint] NOT NULL IDENTITY,
    [Title] [nvarchar](max),
    [ShortDescription] [nvarchar](max),
    [PageCount] [int] NOT NULL,
    [PublicationDate] [datetime] NOT NULL,
    [Price] [float] NOT NULL,
    [MainAuthor_Id] [int],
    CONSTRAINT [PK_dbo.Books] PRIMARY KEY ([ISBN])
) ON [PRIMARY]
GO

CREATE INDEX [IX_MainAuthor_Id] ON [dbo].[Books]([MainAuthor_Id])
GO
ALTER TABLE [dbo].[Books] ADD CONSTRAINT [FK_dbo.Books_dbo.Authors_MainAuthor_Id] FOREIGN KEY ([MainAuthor_Id]) REFERENCES [dbo].[Authors] ([Id])
GO

SET IDENTITY_INSERT [dbo].[Authors] ON
GO

INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (1, N'Doug', N'Bell')
INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (2, N'David', N'Barnes')
INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (3, N'Jacquelien', N'Rothfusz')
INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (4, N'Michael', N'Kölling')
INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (5, N'Ron', N'Emmerik')
INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (6, N'Guy', N'De Tré')
INSERT [dbo].[Authors] ([Id], [FirstName], [LastName]) VALUES (7, N'Titia', N'Struiving')

SET IDENTITY_INSERT [dbo].[Authors] OFF
GO

SET IDENTITY_INSERT [dbo].[Books] ON
GO

INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043032421, N'Programmeren in C#, 2e editie met MyLab NL', N'Programmeren in C# (C Sharp) is geschreven in een eenvoudige, directe en heldere stijl. Het begint met een uitleg over hoe objecten gebruikt worden en gaat in op variabelen, toekenningsopdrachten en methoden. Vervolgens wordt het gebruik van objecten uit bibliotheekklassen geïntroduceerd. En daarna een uileg hoe instructies geschreven worden voor selectie en herhaling. Ten slotte leren studenten hoe zij zelf klassen kunnen schrijven.', 1, 540, '2015/1/7', 44.95)
INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043034999, N'Programmeren in Java met BlueJ, 6e editie met MyLab NL', N'Programmeren in Java met BlueJ is een helder geschreven en compact boek ter inleiding tot objectgeoriënteerd programmeren in Java met behulp van BlueJ, een omgeving die speciaal is ontwikkeld voor het leren programmeren in Java. Het boek is een makkelijk te volgen en uitgebreid naslagwerk dat studenten op een duidelijke manier met Java laat kennismaken en leert Java te doorgronden. Door het oefenmateriaal kunnen studenten deze opgedane kennis meteen in de praktijk uitvoeren.', 2, 664, '2017/3/15', 59.95)
INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043033916, N'Ethiek in sociaal werk, 3e editie met MyLab NL', N'Maatschappelijk werkers, sociaal pedagogisch hulpverleners, pedagogen en cultureel werkers verlenen hulp en diensten aan mensen die kwetsbaar zijn. Hierbij spelen normen en waarden een grote rol. Ethiek in sociaal werk behandelt de belangrijkste ethische begrippen en legt de relatie met de verschillende beroepscodes op dit gebied.', 3, 328, '2017/3/23', 39.95)
INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043018791, N'Programmeren in Java met Greenfoot', N'In Programmeren met Java in Greenfoot leer je hoe je grafische computerprogramma’s programmeert met behulp van de programmeertaal Java en de ontwikkelomgeving Greenfoot.', 4, 232, '2011/1/13', 45.95)
INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043033343, N'Kwaliteitsmanagement, 3e editie met MyLab NL', N'Organisaties onderscheiden zich door de kwaliteit van hun producten of diensten, goede arbeidsomstandigheden en hun houding ten aanzien van duurzaamheid. In dit zeer systematische en toegankelijk geschreven boek bespreekt de auteur de verschillende vormen van kwaliteitsmanagement en de modellen en systemen die hierbij worden gebruikt, waaronder het INK-managementmodel, Six Sigma en Lean. Daarnaast legt hij aan de hand van sprekende voorbeelden een verbinding met de dagelijkse praktijk.', 5, 320, '2016/6/15', 46.95)
INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043035804, N'Principes van databases, 2e editie met MyLab NL', N'Principes van databases geeft inzicht in het uitgebreide domein van databasesystemen. Daarbij besteedt de auteur bijzondere aandacht aan relationele databases en hun objectgeoriënteerde faciliteiten en wordt kort ingegaan op diverse aspecten van andere databasemodellen en NoSQL-oplossingen voor het beheer van ‘big’ data.', 6, 440, '2017/7/11', 51.95)
INSERT [dbo].[Books] ([ISBN], [Title], [ShortDescription], [MainAuthor_Id], [PageCount], [PublicationDate], [Price]) VALUES (9789043035897, N'Professioneel communiceren in de zorg (EC-versie)', N'In Professioneel communiceren in de zorg staat de verpleegkundige als communicerende collega centraal. Professionals met verschillende achtergronden en startniveaus moeten met elkaar samenwerken om een goed team te kunnen vormen en dat lukt alleen wanneer zij effectief communiceren.', 7, 208, '2017/6/1', 34.95)

USE [master]
GO
ALTER DATABASE [Bookstore] SET  READ_WRITE 
GO
