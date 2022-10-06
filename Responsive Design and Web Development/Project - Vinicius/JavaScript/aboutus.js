function swap(picNum)
{
  document.getElementById("MainImage").src =
  "../Images/about" + picNum + ".jpg";
  imgNum = picNum;
}
function next()
{
  if(imgNum==8)
  {
    imgNum=1;
  }
  else imgNum++;
  swap(imgNum);
}
function previous()
{
  if(imgNum==1)
  {
    imgNum=8;
  }
  else imgNum--;

  swap(imgNum);
}
