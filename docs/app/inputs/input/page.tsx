import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Radio Group</Typography>
        <Box sx={{ display: "flex", width: "fit-content" }}>
            <Image
                src={"../inputs/main.png"}
                alt="Image of some simple inputs"

                width={350} height={250} priority

                style={{ borderRadius: "10px",
                    margin: "auto 5%"
                }}
            />
            <Box sx={{ margin: "auto" }}>
                <CodeBlock>{
                    'Input()\n' +
                    'Input(type = InputFieldType.UNDERLINE)\n\n' +

                    'Input(placeholder = "Password", style = DefaultStyles.Input.input.copy(\n' +
                        '\ttext = TextStyle(\n' +
                            '\t\tkeyboardType = KeyboardType.Password\n' +
                        '\t)\n' +
                    '))\n'
                }</CodeBlock>
            </Box>
        </Box>
        <Box marginTop={"25px"}>
            <Typography>
                To customize the input slots, that is things like the lock icon when the input field
                is set to password in styles, the slots argument can be provided to the input.
            </Typography>
            <CodeBlock>{
                "Input(slots = Slots(<icon beginning>, <icon end>))\n\n" +

                'Input(color = "myBackgroundColor", text = "myTextColor")\n'
            }</CodeBlock>

            <Typography>
                The text component visible and hidden text state for password text is already
                fixed so no value is required to hide the text.
            </Typography>
            <Typography marginTop={"25px"}>
                To get the text from the input provide a value state and use the <code>onChange</code>.
            </Typography>
            <CodeBlock>{
                'var email by remember { mutableStateOf("") }\n' +
                'Input(value = email, placeholder = "Enter email", onChange = { email = it })\n'
            }</CodeBlock>
        </Box>
    </div>)
}
