

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.streotypenote.Layouts.Header
import com.example.streotypenote.R
import com.example.streotypenote.ui.theme.setTheme
// PAGE
//@Preview
@Composable
fun HomeScreen(navController: NavController) {
//    val screen = LocalConfiguration.current
//    val screenWidth = screen.screenWidthDp

    setTheme {
        Scaffold(
            topBar = { Header(
                titleText = "브런치"
            ) },
            bottomBar = { Bottoms() },
            floatingActionButton = { FAB(navController) },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            content = { Body() }
        )
    }
}
//floating action button
@Composable
fun FAB(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("post") },
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(50),
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White
            )
        },
    )
}

//Bottom App Bar
@Composable
fun Bottoms() {

    val selectedNavItem = remember { "home" }

    BottomAppBar(
        Modifier
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
        cutoutShape = CircleShape,
        backgroundColor = Color.LightGray,
        contentColor = Color.White,
//        elevation = 10.dp,
        content = {
            BottomNavigationItem(
                selected = selectedNavItem.equals("home"),
                onClick = { /*TODO*/ },
                icon = {
                  Icon(imageVector = Icons.Default.Home, contentDescription = "home icon", Modifier.size(32.dp))
                }
            )
            BottomNavigationItem(
                selected = selectedNavItem.equals("About"),
                onClick = { /*TODO*/ } ,
                icon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "search icon",Modifier.size(32.dp))
                }
            )
        }
    )
}

// BODY
@Composable
fun Body() {
    Column(

    ){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Title()
            RowListView()
        }
        RowCards()
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Second()
        }
    }
}

// Fucking Layout


//TITLE
@Composable
fun Title() {
    Text(
        text = "OOO 작가님의 작품들",
//        style = MaterialTheme.typography.body1
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 28.dp, bottom = 8.dp)
    )
}
// TEXT
@Composable
fun SubTitle() {
    Text(
        text = "오늘 하루는 어떠셨나요?",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun DesignText() {
    Text(
        text = "    오늘 하루 하루를 기록하면서 나만의 책을 만들어 보세요.",
        fontSize = 18.sp,
        color = Color.Gray
    )
}

@Composable
fun Second() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        SubTitle()
        DesignText()
    }
}

// ROW LIST VIEW
@Composable
fun RowListView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        modifier = Modifier
            .padding(vertical =  14.dp),
    ){
       Text(text = "첫번째 챕터", color = Color.Black)
       Text(text = "두번째 챕", color = Color.Gray)
       Text(text = "세번째 챕터", color = Color.Gray)
    }
}

// CARD COMPONENT
//@Preview
@Composable
fun RowCards() {

    // Theme 쪽에서 가져와서 사용하는 방식을 이용해야할 것 같다.
    val screenWidth = LocalConfiguration.current.screenWidthDp

    Row(
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        Spacer(Modifier.width(28.dp))
        myCard(
            content = {
                CardDetail(
                    title = "피크닉",
                    date = "1월 28일",
                    description = "즐거움이 가득했던 따듯한 하루",
                    image = R.drawable.picnic1
                )
            }
        )
        myCard(
            content = {
                CardDetail(
                    title = "레인데이",
                    date = "1월 29일",
                    description = "적막했던 비가 내리던 하루",
                    image = R.drawable.rainday
                )
            }
        )
        myCard()
    }
}

@Composable
fun CardDetail(
    image: Int,
    date: String,
    title: String,
    description: String,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "bookcover iamge",
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(color = Color.Gray, blendMode = BlendMode.Softlight)
    )
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(24.dp)
    ) {
        Text(
            text = date,
            color = Color.White,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            text = description,
            color = Color.White,
        )
    }
}

@Composable
fun myCard(
    content: @Composable () -> Unit = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                Text(text = "새로운 내용을 추가해주세요")
            }
        }
    },
) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 20.dp,
        modifier = Modifier
            .height(400.dp)
            .width(280.dp),
        content = content
    )
}