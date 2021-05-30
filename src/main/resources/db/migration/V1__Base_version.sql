create table Catalog (
ParentCatalog nvarchar (70));
Name nvarchar (70) NOT NULL,

create table Files (
ParentCatalog nvarchar (70),
Name nvarchar (70) NOT NULL,
Size integer);