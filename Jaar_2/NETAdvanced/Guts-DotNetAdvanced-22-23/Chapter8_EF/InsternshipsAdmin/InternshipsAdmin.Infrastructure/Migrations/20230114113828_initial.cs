using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace InternshipsAdmin.Infrastructure.Migrations
{
    public partial class initial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Companies",
                columns: table => new
                {
                    CompanyId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Address = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Zip = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    City = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Companies", x => x.CompanyId);
                });

            migrationBuilder.CreateTable(
                name: "Contacts",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Prefix = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    CompanyId = table.Column<int>(type: "int", nullable: false),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Email = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Phone = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Contacts", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Contacts_Companies_CompanyId",
                        column: x => x.CompanyId,
                        principalTable: "Companies",
                        principalColumn: "CompanyId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Supervisors",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    JobTitle = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Specialism = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    CompanyId = table.Column<int>(type: "int", nullable: false),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Email = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Phone = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Supervisors", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Supervisors_Companies_CompanyId",
                        column: x => x.CompanyId,
                        principalTable: "Companies",
                        principalColumn: "CompanyId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Students",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Department = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    SupervisorId = table.Column<int>(type: "int", nullable: true),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Email = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Phone = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Students", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Students_Supervisors_SupervisorId",
                        column: x => x.SupervisorId,
                        principalTable: "Supervisors",
                        principalColumn: "Id");
                });

            migrationBuilder.InsertData(
                table: "Companies",
                columns: new[] { "CompanyId", "Address", "City", "Name", "Zip" },
                values: new object[] { 1, "Elfde Liniestraat 26", "Hasselt", "PXL Smart ICT", "3500" });

            migrationBuilder.InsertData(
                table: "Companies",
                columns: new[] { "CompanyId", "Address", "City", "Name", "Zip" },
                values: new object[] { 2, "Kempische Steenweg 309", "Hasselt", "Datasense", "3500" });

            migrationBuilder.InsertData(
                table: "Supervisors",
                columns: new[] { "Id", "CompanyId", "Email", "JobTitle", "Name", "Phone", "Specialism" },
                values: new object[] { 1, 1, "227c5e6d-c636-4a37-ae45-6d608071bf17", "e049ea2a-b6da-4276-b72a-3ae19fbe7123", "Paul", "9de8960a-ab80-49c9-b059-53a448b62edd", "9695c4a7-6c37-4bf0-a6cc-ad7b58419629" });

            migrationBuilder.InsertData(
                table: "Supervisors",
                columns: new[] { "Id", "CompanyId", "Email", "JobTitle", "Name", "Phone", "Specialism" },
                values: new object[] { 2, 2, "03dddacf-b8e7-4ad1-b068-cd8e15aa0558", "691fec68-1f52-4202-a690-e1baf5b640c7", "Tamara", "5bcad13b-b7af-411e-b2e1-cfa55307b779", "b5bc64a4-391f-472f-81ac-dd5e0e99c979" });

            migrationBuilder.InsertData(
                table: "Students",
                columns: new[] { "Id", "Department", "Email", "Name", "Phone", "SupervisorId" },
                values: new object[,]
                {
                    { 1, "9f3b6e7b-156f-4768-af77-57a85655fa7d", "fb7dadc9-c3e5-4220-8ca7-ab0be0e2e1f3", "Timmy", "072e5512-4560-4f12-8577-ef07226bb031", 1 },
                    { 2, "a38e8ddd-a050-4542-8486-c8367ed4a21a", "54d59410-92cc-4f14-b33e-3b397f0d84d9", "Phillip", "d1ee4812-5615-45dc-a1ba-d8b3db97a61e", 1 },
                    { 3, "4e0a5e82-88b4-45a3-b679-363e272e42cf", "3ee72a3a-f3fb-402d-a7a1-0a97f50ac77a", "Sofia", "be9dd60f-a894-4b8c-a3ab-58638e216586", 2 },
                    { 4, "9ec86142-2f70-4213-a716-63b48cd61f21", "25dba5ab-f088-488c-a3e9-6ab144c2e655", "Sarah", "a41527ee-85d4-496f-81bf-e5ed45637a1a", 2 }
                });

            migrationBuilder.CreateIndex(
                name: "IX_Contacts_CompanyId",
                table: "Contacts",
                column: "CompanyId",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_Students_SupervisorId",
                table: "Students",
                column: "SupervisorId");

            migrationBuilder.CreateIndex(
                name: "IX_Supervisors_CompanyId",
                table: "Supervisors",
                column: "CompanyId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Contacts");

            migrationBuilder.DropTable(
                name: "Students");

            migrationBuilder.DropTable(
                name: "Supervisors");

            migrationBuilder.DropTable(
                name: "Companies");
        }
    }
}
