USE [JSPDB]
GO
/****** Object:  Table [dbo].[EmployeeA]    Script Date: 2014/5/1 下午 08:15:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EmployeeA](
	[indexNo] [int] NOT NULL,
	[name] [varchar](30) NULL,
	[zip] [varchar](5) NULL,
	[Addr_1] [varchar](30) NULL,
	[Addr_2] [varchar](30) NULL,
	[telDay] [varchar](15) NULL,
	[telNight] [varchar](15) NULL,
	[mobile] [varchar](15) NULL,
	[Email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[indexNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MemberExample]    Script Date: 2014/5/1 下午 08:15:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MemberExample](
	[PK] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](32) NULL,
	[password] [varchar](32) NULL,
	[name] [varchar](32) NULL,
	[email] [varchar](64) NULL,
	[tel] [varchar](15) NULL,
	[experience] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[PK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
