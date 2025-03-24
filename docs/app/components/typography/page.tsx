import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Typography</Typography>
        <Box sx={{ display: "flex", width: "fit-content" }}>
            <Image
                src={"../components/typography/image.png"}
                alt="Image of a three different types of text"

                width={350} height={150} priority

                style={{ borderRadius: "10px",
                    margin: "auto 5%"
                }}
            />
            <Box sx={{ margin: "auto" }}>
                <CodeBlock>{
                    'Typography("Title", type = TextType.TITLE)\n' +
                    'Typography("Medium", type = TextType.MEDIUM_TITLE)\n' +
                    'Typography("Normal")\n'
                }</CodeBlock>
            </Box>
        </Box>
    </div>)
}
