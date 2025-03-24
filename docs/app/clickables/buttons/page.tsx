import CodeBlock from "@/components/code/code"
import { Box, Container, Typography } from "@mui/material"
import Image from "next/image"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Container fixed>
            <Typography variant="h4">Buttons</Typography>
            <Typography>
                The Button component is located at <code>org.android.aui.clickable.Button</code>
            </Typography>

            {/* Main */}
            <Box sx={{ display: "flex", width: "fit-content" }}>
                <Image
                    src={"../clickable/buttons/preview.png"}
                    alt="Image of three simple buttons"

                    width={350} height={125} priority

                    style={{ borderRadius: "10px",
                        margin: "auto 5%"
                    }}
                />
                <Box sx={{ margin: "auto" }}>
                    <CodeBlock>{
                        'Button(type = ButtonType.TEXT)\n' +
                        'Button(type = ButtonType.OUTLINED)\n' +
                        'Button() // Default is ButtonType.CONTAINED\n'
                    }</CodeBlock>
                </Box>
            </Box>
            <Box>
                <Typography>
                    The button uses the <code>ThemeProvider</code> to
                    get its color for both background and text.
                    <br />
                    But by providing <code>backgroundColor</code> or <code>color</code> in
                    the button <code>style</code> parameter
                    - or by setting the <code>color</code> parameter -
                    the buttons color and content color will change.
                </Typography>
                <CodeBlock>{
                'Button(\n' +
                    '\tonClick = {},\n' +
                    '\ttype = ButtonType.CONTAINED,\n' +
                    '\tcolor = "primary",\n' +
                    '\tstyle = DefaultStyles.Clickable.button,\n' +
                    '\tdisabled = false\n' +
                ') {\n' +
                    '\t...\n' +
                '}\n'
                }</CodeBlock>
            </Box>

            <Box sx={{ marginTop: "125px" }}>
                <Typography variant="h5">Disabled and Enabled Buttons</Typography>
                <Box sx={{ display: "flex", width: "fit-content" }}>
                    <Image
                        src={"../clickable/buttons/button enabled.png"}
                        alt="Image of Disabled and Enabled buttons"

                        width={350} height={75} priority

                        style={{ borderRadius: "10px",
                            margin: "auto 5%"
                        }}
                    />
                    <Box sx={{ margin: "auto" }}>
                        <CodeBlock>{
                            'Button() { ... }\n' +
                            'Button(disabled = true) { ... }\n'
                        }</CodeBlock>
                    </Box>
                </Box>
            </Box>
        </Container>
    </div>)
}
