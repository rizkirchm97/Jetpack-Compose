package com.rizkir.androiddevtest.presentation.login.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rizkir.androiddevtest.domain.model.LoginRequest
import com.rizkir.androiddevtest.presentation.login.LoginEvent
import com.rizkir.androiddevtest.presentation.login.LoginViewModel
import com.rizkir.androiddevtest.ui.theme.Purple700
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */
@Composable
fun LoginPage(
    viewModel: LoginViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple700
            )
        )
    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val coroutineScope = rememberCoroutineScope()
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val context = LocalContext.current

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        makeToast(
                            context = context,
                            message = "Login Success",
                            LoginRequest(email = username.value.text, password = password.value.text),
                            viewModel
                        )
                    }

        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
        ) {
        Text(text = "Login")
    }
    }

    Spacer(modifier = Modifier.height(20.dp))
    ClickableText(
        text = AnnotatedString("Forgot password?"),
        onClick = { },
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Default
        )
    )
}
}

suspend fun makeToast(
    context: Context,
    message: String,
    loginRequest: LoginRequest,
    viewModel: LoginViewModel
) {
    viewModel.onEvent(LoginEvent.Login(loginRequest))
    viewModel.loginState.collectLatest { result ->
        if (result.data != null) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}
