USE [JDBC]
GO
/****** Object:  StoredProcedure [dbo].[proProductByPrice]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[proProductByPrice]
	@param_price float AS
BEGIN
	SET NOCOUNT ON;
	SELECT * FROM product WHERE price>@param_price
END

GO
/****** Object:  StoredProcedure [dbo].[qry_emp]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[qry_emp] (
	@Empno		decimal(4),
	@Empname	varchar(30)		OUT,
	@Salary		decimal(10,2)	OUT
)
AS
BEGIN
	SELECT @Empname = empname, @Salary = salary FROM employee WHERE empno = @Empno;
END;

GO
/****** Object:  StoredProcedure [dbo].[upd_emp_salary]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[upd_emp_salary] (
	@Salary		decimal(10,2),
	@Empno		decimal(4)
)
AS
BEGIN
	UPDATE employee SET salary = @Salary WHERE empno = @Empno;
END;

GO
/****** Object:  Table [dbo].[account]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account](
	[accountid] [varchar](20) NOT NULL,
	[password] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[accountid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[accountrole]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[accountrole](
	[accountid] [varchar](20) NOT NULL,
	[roleid] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[accountid] ASC,
	[roleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[blobTest]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[blobTest](
	[fileName] [varchar](30) NOT NULL,
	[blobData] [image] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[fileName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[blog]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[blog](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[articleId] [int] NULL,
	[nickname] [varchar](20) NULL,
	[retime] [datetime] NULL,
	[reply] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[customer]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[custid] [varchar](20) NOT NULL,
	[password] [varbinary](50) NULL,
	[email] [varchar](30) NULL,
	[birth] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[custid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[department]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[department](
	[deptno] [varchar](3) NOT NULL,
	[deptname] [varchar](30) NOT NULL,
	[location] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[deptno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Dept]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Dept](
	[deptid] [int] NOT NULL,
	[deptname] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[deptid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[detail]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detail](
	[photoid] [int] NOT NULL,
	[photo] [image] NULL,
PRIMARY KEY CLUSTERED 
(
	[photoid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Emp]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Emp](
	[empid] [int] IDENTITY(1,1) NOT NULL,
	[empname] [varchar](10) NULL,
	[salary] [int] NULL,
	[sex] [char](1) NULL,
	[photo] [image] NULL,
	[deptid] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[empid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employee]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employee](
	[empno] [decimal](4, 0) NOT NULL,
	[empname] [varchar](30) NOT NULL,
	[hiredate] [datetime] NOT NULL,
	[salary] [decimal](10, 2) NOT NULL,
	[deptno] [varchar](3) NOT NULL,
	[title] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[empno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employees](
	[id] [int] NOT NULL,
	[age] [int] NOT NULL,
	[first] [varchar](255) NULL,
	[last] [varchar](255) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GuestBooks]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[GuestBooks](
	[title] [varchar](255) NULL,
	[content] [varchar](255) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Item]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Item](
	[id] [int] NOT NULL,
	[username] [varchar](20) NOT NULL,
	[title] [varchar](100) NOT NULL,
	[year] [char](4) NOT NULL,
	[genre] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ObjectIDs]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ObjectIDs](
	[table_name] [varchar](30) NOT NULL,
	[id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[table_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] NOT NULL,
	[name] [varchar](20) NULL,
	[price] [float] NULL,
	[make] [datetime] NULL,
	[expire] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Proj]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Proj](
	[projid] [int] NOT NULL,
	[projname] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[projid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ProjEmp]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProjEmp](
	[projid] [int] NOT NULL,
	[empid] [int] NOT NULL,
 CONSTRAINT [PK_PROJEMP_PROJIDEMPID] PRIMARY KEY CLUSTERED 
(
	[projid] ASC,
	[empid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[stock]    Script Date: 2014/5/1 下午 08:13:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[stock](
	[symbol] [varchar](10) NOT NULL,
	[price] [decimal](6, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[symbol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[accountrole]  WITH CHECK ADD FOREIGN KEY([accountid])
REFERENCES [dbo].[account] ([accountid])
GO
ALTER TABLE [dbo].[detail]  WITH CHECK ADD FOREIGN KEY([photoid])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[Emp]  WITH CHECK ADD FOREIGN KEY([deptid])
REFERENCES [dbo].[Dept] ([deptid])
GO
ALTER TABLE [dbo].[ProjEmp]  WITH CHECK ADD  CONSTRAINT [FK_PROJEMP_EMP_EMPID] FOREIGN KEY([empid])
REFERENCES [dbo].[Emp] ([empid])
GO
ALTER TABLE [dbo].[ProjEmp] CHECK CONSTRAINT [FK_PROJEMP_EMP_EMPID]
GO
ALTER TABLE [dbo].[ProjEmp]  WITH CHECK ADD  CONSTRAINT [FK_PROJEMP_PROJ_PROJID] FOREIGN KEY([projid])
REFERENCES [dbo].[Proj] ([projid])
GO
ALTER TABLE [dbo].[ProjEmp] CHECK CONSTRAINT [FK_PROJEMP_PROJ_PROJID]
GO
