import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Indicators</Typography>

        {/* Linear Progress */}
        <Box marginTop={"25px"}>
            <Typography variant="h5">Linear Progress</Typography>
            <div id="linearProgress" />
            <Box sx={{ display: "flex", width: "fit-content" }}>
                <Image
                    src={"../components/indicators/linearProgress.gif"}
                    alt="Gif of linear progress"

                    width={350} height={75} priority

                    style={{ borderRadius: "10px",
                        margin: "auto 5%"
                    }}
                />
                <Box sx={{ margin: "auto" }}>
                    <CodeBlock>{"LinearProgress()"}</CodeBlock>
                </Box>
            </Box>
            <Box>
                <CodeBlock>{
                    'LinearProgress(color = "primary", background = "background", style = DefaultStyles.Indicator.linear)'
                }</CodeBlock>
            </Box>
        </Box>
    </div>)
}
