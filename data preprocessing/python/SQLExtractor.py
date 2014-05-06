#!/usr/bin/python

import MySQLdb

#Dictionary for Mysql database details
conDetails={
  'server': '',
  'username': '',
  'password': '',
  'database': ''
  }

#Cursor to connect database
cursor=""

#title-id dictionary
idTitleDic={}
titleIdDic={}

#Database connector

def dbCon():
  global conDetails, cursor
  fread=open("properties.txt","r")
  line=fread.readline() #skipping first line
  
  for line in fread.readlines():
    word=line.split(":")
    if conDetails.has_key(word[0].strip()):
      conDetails[word[0].strip()]=word[1].strip()
      
  db=MySQLdb.connect(conDetails['server'],conDetails['username'],conDetails['password'],conDetails['database'])
  
  cursor=db.cursor()


#To create page titleI-d dictionary

def setPageDic():
  global titleIdDic, idTitleDic
  
  fread=open("getPageTitleById.txt","r")
  
  for line in fread:
    word=line.split()
    #print word
    try:
      titleIdDic[word[1]]=word[0]
      idTitleDic[word[0]]=word[1]
    except:
      pass


#To create category titleI-d dictionary

def setCatDic():
  global titleIdDic, idTitleDic
  
  fread=open("getCategoryTitleById.txt","r")
  
  for line in fread:
    word=line.split()
    titleIdDic[word[1]]=word[0]
    idTitleDic[word[0]]=word[1]


#links=0 means key = title and value = id
#links=1 means key = id and value = title

def getListAndTotal(sql, flistIdById, flistIdByTitle, flistTitleByTitle, ftotalById, ftotalByTitle, links):
  
  global titleIdDic, idTitleDic, cursor

  cursor.execute(sql)
  print "sql"
  listOfId=[]
  listOfTitle=[]
  prevKey=""
  
  for i in range(cursor.rowcount):
    row = cursor.fetchone()
    
    key=str(row[0])
    value=str(row[1])
    
    if prevKey==key:

      listOfId=addValueToListOfId(key, value, links, listOfId)      
      listOfTitle=addValueToListOfTitle(key, value, links, listOfTitle)
      if links==0:
	if not idTitleDic.has_key(value) or not titleIdDic.has_key(key):
	  continue
	writeListAndTotal(titleIdDic[key], listOfId, ftotalById, flistIdById)
	writeListAndTotal(key, listOfTitle, ftotalByTitle, flistIdByTitle)
	writeList(key, listOfTitle, flistTitleByTitle)
      else:
	if not titleIdDic.has_key(value) or not idTitleDic.has_key(key):
	  continue
	writeListAndTotal(key, listOfId, ftotalById, flistIdById)
	writeListAndTotal(idTitleDic[key], listOfTitle, ftotalByTitle, flistIdByTitle)
	writeList(idTitleDic[key], listOfTitle, flistTitleByTitle)
      
    else:
      if i!=0:
	if links==0:
          if not idTitleDic.has_key(value) or not titleIdDic.has_key(key):
            continue
	  writeListAndTotal(titleIdDic[key], listOfId, ftotalById, flistIdById)
	  writeListAndTotal(key, listOfTitle, ftotalByTitle, flistIdByTitle)
	  writeList(key, listOfTitle, flistTitleByTitle)
	else:
          if not titleIdDic.has_key(value) or not idTitleDic.has_key(key):
            continue
	  writeListAndTotal(key, listOfId, ftotalById, flistIdById)
	  writeListAndTotal(idTitleDic[key], listOfTitle, ftotalByTitle, flistIdByTitle)
	  writeList(idTitleDic[key], listOfTitle, flistTitleByTitle)
	
      prevKey=row[0]
      listOfId=[]
      listOfTitle=[]
      
      listOfId=addValueToListOfId(key, value, links, listOfId)      
      listOfTitle=addValueToListOfTitle(key, value, links, listOfTitle)      
	
      
  del listOfId
  del listOfTitle
  del(cursor)
  del(db)
  flistIdById.close()
  flistIdByTitle.close()
  flistTitleByTitle.close()
  ftotalById.close()
  ftotalByTitle.close()
  


def addValueToListOfId(key , value, listOfId, links ):
  if links==0:
    if not idTitleDic.has_key(value) or not titleIdDic.has_key(key):
      listOfId.append(value)
  else:
    if not titleIdDic.has_key(value) or not idTitleDic.has_key(key):
      listOfId.append(titleIdDic[value])
    
  return listOfId


    
def addValueToListOfTitle(key , value, listOfTitle, links):
  if links==0:
    if not idTitleDic.has_key(value) or not titleIdDic.has_key(key):
      listOfTitle.append(idTitleDic[value])
  else:
    if not titleIdDic.has_key(value) or not idTitleDic.has_key(key):
      listOfTitle.append(value)
    
  return listOfTitle



def writeListAndTotal(key, listOfValue, ftotal, flist):
  flist.write(key+"\t")
  ftotal.write(key+"\t")
  count=len(listOfValue)
  for x in range(count):
    flist.write(str(listOfValue[x]))
    if x!=count-1:
      flist.write(",")
  flist.write("\n")
  ftotal.write(str(count)+"\n")
  

def writeList(key, listOfValue, flist):
  flist.write(key+"\t")
  count=len(listOfValue)
  for x in range(count):
    flist.write(str(listOfValue[x]))
    if x!=count-1:
      flist.write(",")
  flist.write("\n")


def inLinks():
  print "Creating inlink data..."
  fgetListOfInlinksIdById= open("getListOfInlinksIdById.txt","w")
  fgetListOfInlinksIdByTitle= open("getListOfInlinksIdByTitle.txt","w")
  fgetListOfInlinksTitleByTitle= open("getListOfInlinksIdByTitle.txt","w")
  fgetTotalInlinksById= open("getTotalInlinksById.txt","w")
  fgetTotalInlinksByTitle= open("getTotalInlinksByTitle.txt","w")
  
  sql="select pl_title, pl_from from pagelinks order by pl_title";

  getListAndTotal(sql, fgetListOfInlinksIdById, fgetListOfInlinksIdByTitle, fgetListOfInlinksTitleByTitle, fgetTotalInlinksById, fgetTotalInlinksByTitle, 0)

  fgetListOfInlinksIdById.flush()
  fgetListOfInlinksIdByTitle.flush()
  fgetListOfInlinksTitleByTitle.flush()
  fgetTotalInlinksById.flush()
  fgetTotalInlinksByTitle.flush()
  
  fgetListOfInlinksIdById.close()
  fgetListOfInlinksIdByTitle.close()
  fgetListOfInlinksTitleByTitle.close()
  fgetTotalInlinksById.close()
  fgetTotalInlinksByTitle.close()
  print "Done"
 
  
def outLinks():
  print "Creating outlink data..."
  fgetListOfOutlinksIdById= open("getListOfOutlinksIdById.txt","w")
  fgetListOfOutlinksIdByTitle= open("getListOfOutlinksIdByTitle.txt","w")
  fgetListOfOutlinksTitleByTitle= open("getListOfOutlinksIdByTitle.txt","w")
  fgetTotalOutlinksById= open("getTotalOutlinksById.txt","w")
  fgetTotalOutlinksByTitle= open("getTotalOutlinksByTitle.txt","w")
  
  sql="select pl_from, pl_title from pagelinks order by pl_from";

  getListAndTotal(sql, fgetListOfOutlinksIdById, fgetListOfOutlinksIdByTitle, fgetListOfOutlinksTitleByTitle, fgetTotalOutlinksById, fgetTotalOutlinksByTitle, 1)

  fgetListOfOutlinksIdById.flush()
  fgetListOfOutlinksIdByTitle.flush()
  fgetListOfOutlinksTitleByTitle.flush()
  fgetTotalOutlinksById.flush()
  fgetTotalOutlinksByTitle.flush()
  
  fgetListOfOutlinksIdById.close()
  fgetListOfOutlinksIdByTitle.close()
  fgetListOfOutlinksTitleByTitle.close()
  fgetTotalOutlinksById.close()
  fgetTotalOutlinksByTitle.close()
  print "Done"


def catChildren():
  print "Creating category children data..."
  fgetListOfChildrenIdById= open("getListOfChildrenIdById.txt","w")
  fgetListOfChildrenIdByTitle= open("getListOfChildrenIdByTitle.txt","w")
  fgetListOfChildrenTitleByTitle= open("getListOfChildrenIdByTitle.txt","w")
  fgetNoOfChildrenById= open("getNoOfChildrenById.txt","w")
  fgetNoOfChildrenByTitle= open("getNoOfChildrenByTitle.txt","w")
  
  sql="select cl_to, cl_from from categorylinks where cl_type='subcat' order by cl_to";

  getListAndTotal(sql, fgetListOfChildrenIdById, fgetListOfChildrenIdByTitle, fgetListOfChildrenTitleByTitle, fgetNoOfChildrenById, fgetNoOfChildrenByTitle, 0)

  fgetListOfChildrenIdById.flush()
  fgetListOfChildrenIdByTitle.flush()
  fgetListOfChildrenTitleByTitle.flush()
  fgetNoOfChildrenById.flush()
  fgetNoOfChildrenByTitle.flush()
  
  fgetListOfChildrenIdById.close()
  fgetListOfChildrenIdByTitle.close()
  fgetListOfChildrenTitleByTitle.close()
  fgetNoOfChildrenById.close()
  fgetNoOfChildrenByTitle.close()
  print "Done"
 

def catParent():
  print "Creating category parents  data..."
  fgetListOfParentsIdById= open("getListOfParentsIdById.txt","w")
  fgetListOfParentsIdByTitle= open("getListOfParentsIdByTitle.txt","w")
  fgetListOfParentsTitleByTitle= open("getListOfParentsIdByTitle.txt","w")
  fgetNoOfParentsById= open("getNoOfParentsById.txt","w")
  fgetNoOfParentsByTitle= open("getNoOfParentsByTitle.txt","w")
  
  sql="select cl_from, cl_to from categorylinks where cl_type='subcat' order by cl_from";

  getListAndTotal(sql, fgetListOfParentsIdById, fgetListOfParentsIdByTitle, fgetListOfParentsTitleByTitle, fgetNoOfParentsById, fgetNoOfParentsByTitle, 1)

  fgetListOfParentsIdById.flush()
  fgetListOfParentsIdByTitle.flush()
  fgetListOfParentsTitleByTitle.flush()
  fgetNoOfParentsById.flush()
  fgetNoOfParentsByTitle.flush()
  
  fgetListOfParentsIdById.close()
  fgetListOfParentsIdByTitle.close()
  fgetListOfParentsTitleByTitle.close()
  fgetNoOfParentsById.close()
  fgetNoOfParentsByTitle.close()
  print "Done"
  

def catPage():
  print "Creating category page data..."
  fgetListOfPageIdById= open("getListOfPageIdById.txt","w")
  fgetListOfPageIdByTitle= open("getListOfPageIdByTitle.txt","w")
  fgetListOfPageTitleByTitle= open("getListOfPageIdByTitle.txt","w")
  fgetNoOfPageById= open("getNoOfPageById.txt","w")
  fgetNoOfPageByTitle= open("getNoOfPageByTitle.txt","w")
  
  sql="select cl_to, cl_from from categorylinks where cl_type='page' order by cl_to";

  getListAndTotal(sql, fgetListOfPageIdById, fgetListOfPageIdByTitle, fgetListOfPageTitleByTitle, fgetNoOfPageById, fgetNoOfPageByTitle, 1)

  fgetListOfPageIdById.flush()
  fgetListOfPageIdByTitle.flush()
  fgetListOfPageTitleByTitle.flush()
  fgetNoOfPageById.flush()
  fgetNoOfPageByTitle.flush()
  
  fgetListOfPageIdById.close()
  fgetListOfPageIdByTitle.close()
  fgetListOfPageTitleByTitle.close()
  fgetNoOfPageById.close()
  fgetNoOfPageByTitle.close()
  print "Done"

 
if __name__ == '__main__':

  dbCon()
  titleIdDic.clear()
  idTitleDic.clear()
  catChildren()
  catParent()
  titleIdDic.clear()
  idTitleDic.clear()
  setPageDic()
  inLinks()
  outLinks()
  catPage()
  del titleIdDic
  del idTitleDic
  del conDetails
