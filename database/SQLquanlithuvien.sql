create database quanlythuvien
go
use quanlythuvien
go
create table BangQuanTri
(
	MaNV char(5) not null primary key,
	Hoten nvarchar(50) not null,
	Ngaysinh char(10) not null,
	Gioitinh nvarchar(3) null,
	Chucvu nvarchar(15) null,
	Diachi nvarchar(100) null,
	tkNV char(20) not null,
	mkNV char(20) not null
)
insert into BangQuanTri
	values('NV01',N'Nguyễn Văn Tuấn','20/11/1998',N'Nam',N'Thủ thư',N'Đà Nẵng','nvtuan','1'),
		  ('NV02',N'Phạm Văn Minh','15/11/1996',N'Nam',N'Thủ thư',N'Đà Nẵng','nvminh','1'),
		  ('NV03',N'Nguyễn Ngọc Minh Anh','24/02/1995',N'Nữ',N'Thủ thư',N'Đà Nẵng','nmanh','1'),
		  ('NV04',N'Nguyễn Thị Diễm Quỳnh','03/11/1998',N'Nữ',N'Thủ kho',N'Đà Nẵng','ndquynh','1'),
		  ('NV05',N'Nguyễn Văn Anh','24/05/1997',N'Nam',N'Thủ kho',N'Đà Nẵng','nvanh','1');
create table LoaiSach
(
	Maloai char(10) not null primary key,
	Tenloai nvarchar(20) null 
	)
insert into LoaiSach
	values('S001',N'sách giáo khoa'),
		  ('S002',N'sách giáo trinh'),
		  ('S003',N'sách bài tập'),
		  ('S004',N'sách giải bài tâp'),
		  ('S005',N'truyện');

create table NhaXuatBan
(
	MAXB char(5) primary key,
	TenXB char(20) ,
	Diachi nvarchar(100) null
	
)
insert into NhaXuatBan
	values('BGD','Bo GD-DT',N'Hà Nội'),
		  ('HDQG','Đai hoc Quoc gia',N'Hà Nội'),
		  ('KD','Kim Dong',N'Hà Nội');
create table Sach
(
	Masach char(10) not null primary key,
	Tensach nvarchar(50) not null ,
	Tacgia nvarchar(20) ,
	TenXB nvarchar(20),
	NamXB int,
	Sotrang int,
	Gia int,
	Maloai char(10),
	
)
 insert into Sach
	values('TCC1',N'Toán cao cấp 1', N'Phạm Văn Bình',N'Đại Học Quốc Gia',1998,100,89000,'S002' ),
		  ('TCC2',N'Toán cao cấp 2', N'Phạm Văn Bình',N'Đại Học Quốc Gia',1998,100,49000,'S002' );



-- Tạo hàm tự tăng mamuon

CREATE FUNCTION AUTO_IDMM()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(MaMuon) FROM MuonTra) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MaMuon, 3)) FROM MuonTra
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'MS00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'MS0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END




create table MuonTra
(
	MaMuon char(5) PRIMARY KEY CONSTRAINT IDKH DEFAULT DBO.AUTO_IDMM(),
	MaDG char(5) not null,
	Masach char(5) not null,
	Ngaymuon char(20),
	Ngayhentra char(20),
	Ngaytra char(20),
	
)



insert into MuonTra
	values('MS001','MDG01','TCC2','2/2/2022','2/8/2022','5/6/2022'),
		  ('MS002','MDG01','TCC1','2/2/2022','2/8/2022','5/6/2022');
create table Docgia
(
	MaDocgia char(5) not null primary key,
	Tendocgia nvarchar(50) not null ,
	Tendangnhap nvarchar(50),
	Matkhau varchar(20),
	Namsinh nvarchar(100) null,
	Gioitinh nvarchar(10) null,
	Lop nvarchar(20) null
)

insert into Docgia
	values('MDG01',N'Nguyễn Văn Nam','NguyenNam','12345','2002',N'Nam', '20T1'),
		  ('MDG02',N'Nguyễn Văn Nhân','NguyenNhan','23456',N'2001',N'Nam', '21D2');