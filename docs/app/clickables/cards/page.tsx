import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Cards</Typography>

        {/* Main */}
        <Box sx={{ display: "flex", width: "fit-content" }}>
            <Image
                src={"../clickable/cards/card.png"}
                alt="Image of a simple card"

                width={350} height={350} priority

                style={{ borderRadius: "10px",
                    margin: "auto 5%"
                }}
            />
            <Box sx={{ margin: "auto" }}>
                <CodeBlock>{
                    "Card {\n" +
                        "\tCardImage(\n" +
                            '\t\t"https://flowbite.com/docs/images/examples/image-1@2x.jpg",\n' +
                            '\t\t"Image"\n' +
                        "\t)\n" +
                        '\tCardTitle("My Card")\n' +
                        '\tCardText("Image : Flowbite")\n' +
                    "}\n"
                }</CodeBlock>
            </Box>
        </Box>
        <Box marginTop={"25px"}>
            <Typography>
                The <code>Card</code> components comes with a set of
                content components for <code>Images</code>, <code>Titles</code> and <code>Text</code>.
            </Typography>
            <Typography>
                Each component comes with its own styling options.
                <br />
                The main component, <code>Card</code>, has a <code>onClick</code> callback
                for handling card interactions.
            </Typography>
            <CodeBlock>{"Card(onClick = {}) { ... }"}</CodeBlock>
        </Box>
        <Box marginTop={"25px"}>
            <Typography>
                The text components has a <code>color</code> argument for changing the color
                of the text if the color is not set in the style settings.
            </Typography>
            <CodeBlock>{
                'CardTitle("Title", color = "myColor")\n\n' +
                'CardText("Text", color = "myColor")\n'
            }</CodeBlock>
        </Box>
        <Box marginTop={"25px"}>
            <Typography>
                When using the <code>CardImage</code> component a source to the image and an
                alternate text is required.
            </Typography>
            <CodeBlock>{
                'CardImage(url, "Alternate image text")\n'
            }</CodeBlock>
            <Typography>
                It is also possible to use a local image with <code>R</code>
            </Typography>
            <CodeBlock>{'CardImage(R.drawable.image, "Alternate image text")'}</CodeBlock>
        </Box>
    </div>)
}
