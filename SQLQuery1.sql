create database SQLWeather
go
use SQLWeather;

DROP DATABASE SQLWeather
create table Cay(
Macay int Primary key identity, 
Ten nvarchar(20),
Soluong int,
Dientich float,
Tuoi int,
Maloai varchar(2)
)

create table Chitietlichtuoi(
MaHD int,
Macay int,
Primary key(MaHD,Macay)
)

create table Lichtuoicay(
MaHD int Primary key,
Chuthich nvarchar(500),
Ngaylam datetime,
Tinhtrang bit
)

create table Giaidoancay(
Macay int,
MaGD varchar(2),
primary key (Macay,MaGD)
)

create table Giaidoan(
MaGD varchar(2) primary key,
Giaidoan nvarchar 
)

create table Loaicay(
Maloai varchar(2) primary key,
Loai NVARCHAR (20)
)

create table Chedotuoi(
MaGD varchar(2),
Maloai varchar(2),
Luongnuoc float,
Luongmuahuuich float,
NgayBD int,
NgayKT int
)

alter table Cay
add constraint LK_Cay_Loaicay
foreign key (Maloai)
references Loaicay(Maloai)

alter table Chitietlichtuoi
add constraint LK_Chitietlichtuoi_Cay
foreign key (Macay)
references Cay(Macay)

alter table Chitietlichtuoi
add constraint LK_Chitietlichtuoi_Lichtuoicay
foreign key (MaHD)
references Lichtuoicay(MaHD)

alter table Giaidoancay
add constraint LK_Giaidoancay_Cay
foreign key (Macay)
references Cay(Macay)

alter table Giaidoancay
add constraint LK_Giaidoancay_Giaidoan
foreign key (MaGD)
references Giaidoan(MaGD)

alter table Chedotuoi
add constraint LK_Chedotuoi_Giaidoan
foreign key (MaGD)
references Giaidoan(MaGD)

alter table Chedotuoi
add constraint LK_Chedotuoi_Loaicay
foreign key (Maloai)
references Loaicay(Maloai)

alter table CheDoTuoi
add constraint U_CDT unique(Maloai,MaGD,NgayBD,NgayKT)


insert into Loaicay 
values('AQ',N'Cây ăn quả');

insert into Cay(Ten,Soluong,Dientich,Tuoi,Maloai)
values(N'Táo',10,20,30,'AQ'),
(N'Cam',10,20,30,'AQ'),
(N'Chuối',10,20,30,'AQ');

SELECT* From Cay
